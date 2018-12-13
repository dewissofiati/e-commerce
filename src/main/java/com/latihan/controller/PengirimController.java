package com.latihan.controller;

import com.latihan.entity.Pengirim;
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
public class PengirimController {

    @GetMapping("/pengirim")
    public void exampleReport(HttpServletResponse response) throws JRException, IOException {
        InputStream jasperStream = this.getClass().getResourceAsStream("/jasper/Pengirim.jasper");
        Map<String, Object> params = new HashMap<>();

        Pengirim pengirim1 = new Pengirim("001","J&T Express","089120934758", new BigDecimal(11000), "3 hari");
        Pengirim pengirim2 = new Pengirim("002","JNE Express","081098765432", new BigDecimal(10000), "3 hari");
        Pengirim pengirim3 = new Pengirim("003","JET Express","081234567890", new BigDecimal(9500), "3 hari");
        List<Pengirim> listPengirim = Arrays.asList(pengirim1, pengirim2, pengirim3);

        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(listPengirim));
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=daftar-pengirim.pdf");

        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }
}
