package com.latihan.controller;

import com.latihan.entity.Toko;
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
public class TokoController {

    @GetMapping("/toko")
    public void exampleReport(HttpServletResponse response) throws JRException, IOException {
        InputStream jasperStream = this.getClass().getResourceAsStream("/jasper/Toko.jasper");
        Map<String, Object> params = new HashMap<>();

        Toko tokoSatu = new Toko("001","Grandma Kellys Homestead","Regina Murphy","707 Oxford Rd.","Ann Arbor","08573456789","48104");
        Toko tokoDua = new Toko("002","Bigfoot Breweries","Cheryl Saylor","3400 - 8th Avenue Suite 210","Bend","089967457382","97101");


        List<Toko> listToko = Arrays.asList(tokoSatu, tokoDua);

        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(listToko));
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=daftar-toko.pdf");

        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }
}
