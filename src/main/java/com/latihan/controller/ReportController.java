package com.latihan.controller;

import com.latihan.entity.Kategori;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/report")
public class ReportController {

    @GetMapping("/example")
    public void exampleReport(HttpServletResponse response) throws JRException, IOException{
        InputStream jasperStream = this.getClass().getResourceAsStream("/jasper/tampil.jasper");
        Map<String, Object> params = new HashMap<>();
        params.put("nama", "Dewi Syarah");

        Kategori kategori = new Kategori("001", "Beverages", "Soft drinks, coffees, teas, beers, and ales");
        params.put("kategori", kategori);

        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params);
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=tampil-e_commerce.pdf");

        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }
}
