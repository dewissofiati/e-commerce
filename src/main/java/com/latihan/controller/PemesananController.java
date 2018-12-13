package com.latihan.controller;

import com.latihan.entity.*;
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
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/report")
public class PemesananController {

    @GetMapping("/pemesanan")
    public void exampleReport(HttpServletResponse response) throws JRException, IOException {
        InputStream jasperStream = this.getClass().getResourceAsStream("/jasper/Pemesanan.jasper");
        Map<String, Object> params = new HashMap<>();

        Kategori satu = new Kategori("001", "Beverages", "Soft drinks, coffees, teas, beers, and ales");
        List<Kategori> daftarKategori = Arrays.asList(satu);
        Konsumen konSatu = new Konsumen("001", "Dewi Syarah", "Jl Baturaden IX No.16A", "40286", "Bandung", "08122044290", "dewissofiati@gmail.com");
        Toko tokoDua = new Toko("002","Bigfoot Breweries","Cheryl Saylor","3400 - 8th Avenue Suite 210","Bend","089967457382","97101");
        Produk produk1 = new Produk("001","Chais",new BigDecimal(18000),200,satu,tokoDua, daftarKategori);

        Pemesanan pemesanan = new Pemesanan("001",konSatu,produk1,tokoDua,2,new BigDecimal(20000),new BigDecimal(40000));
        List<Pemesanan> listPemesanan = Arrays.asList(pemesanan);

        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(listPemesanan));
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=daftar-pemesanan.pdf");

        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }
}
