package com.latihan.controller;

import com.latihan.entity.Konsumen;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/report")
public class KonsumenController {

    @GetMapping("/konsumen")
    public void exampleReport(HttpServletResponse response) throws JRException, IOException {
        InputStream jasperStream = this.getClass().getResourceAsStream("/jasper/Konsumen.jasper");
        Map<String, Object> params = new HashMap<>();

        Konsumen konsumenSatu = new Konsumen("001", "Dewi Syarah", "Jl Baturaden IX No.16A", "40286", "Bandung", "08122044290", "dewissofiati@gmail.com");
        Konsumen konsumenDua = new Konsumen("002","Antonio Moreno Taquería","Mataderos 2312","05023","Mexico","081224849576","antonio@gmail.com");
        List<Konsumen> listKonsumen = Arrays.asList(konsumenSatu, konsumenDua);

        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(listKonsumen));
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=daftar-konsumen.pdf");

        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }
}
