package com.latihan.controller;

import com.latihan.entity.Pembayaran;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/report")
public class PembayaranController {

    @GetMapping("/pembayaran")
    public void exampleReport(HttpServletResponse response) throws JRException, IOException {
        InputStream jasperStream = this.getClass().getResourceAsStream("/jasper/Pembayaran.jasper");
        Map<String, Object> params = new HashMap<>();

        Pembayaran pembayaran1 = new Pembayaran("001","Transfer Bank",new BigDecimal(0),"Pembayaran-> Lain-lain-> Belanja Online-> Kode Pembayaran-> Tranfer");
        Pembayaran pembayaran2 = new Pembayaran("002","Bayar di Indomaret",new BigDecimal(2500),"Pembayaran-> Belanja Online-> Cetak Struk-> Bayar di kasir");

        List<Pembayaran> listPembayaran = Arrays.asList(pembayaran1, pembayaran2);

        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(listPembayaran));
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=daftar-pembayaran.pdf");

        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }
}
