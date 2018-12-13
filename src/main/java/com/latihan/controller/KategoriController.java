package com.latihan.controller;

import com.latihan.entity.Kategori;
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
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/report")
public class KategoriController {

    @GetMapping("/kategori")
    public void exampleReport(HttpServletResponse response) throws JRException, IOException {
        InputStream jasperStream = this.getClass().getResourceAsStream("/jasper/Kategori.jasper");
        Map<String, Object> params = new HashMap<>();

        Kategori satu = new Kategori("001", "Beverages", "Soft drinks, coffees, teas, beers, and ales");
        Kategori dua = new Kategori("002", "Condiments", "Sweet and savory sauces, relishes, spreads, and seasonings");
        Kategori tiga = new Kategori("003", "Confections", "Desserts, candies, and sweet breads");
        Kategori empat = new Kategori("004", "Dairy Products", "Cheeses");
        Kategori lima = new Kategori("005", "Grains/Cereals", "Breads, crackers, pasta, and cereal");
        Kategori enam = new Kategori("006", "Meat/Poultry", "Prepared meats");
        Kategori tujuh = new Kategori("007", "Produce", "Dried fruit and bean curd");
        Kategori delapan = new Kategori("008", "Seafood", "Seaweed and fish");

        List<Kategori> listKategori = Arrays.asList(satu, dua, tiga, empat, lima, enam, tujuh, delapan);

        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(listKategori));
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=daftar-kategori.pdf");

        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }
}
