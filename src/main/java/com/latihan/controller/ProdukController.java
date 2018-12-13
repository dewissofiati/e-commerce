package com.latihan.controller;

import com.latihan.entity.Kategori;
import com.latihan.entity.Produk;
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
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/report")
public class ProdukController {

    @GetMapping("/produk")
    public void exampleReport(HttpServletResponse response) throws JRException, IOException {
        InputStream jasperStream = this.getClass().getResourceAsStream("/jasper/Produk.jasper");
        Map<String, Object> params = new HashMap<>();

        Kategori satu = new Kategori("001", "Beverages", "Soft drinks, coffees, teas, beers, and ales");
        Kategori dua = new Kategori("002", "Condiments", "Sweet and savory sauces, relishes, spreads, and seasonings");
        Kategori tiga = new Kategori("003", "Confections", "Desserts, candies, and sweet breads");
        Kategori empat = new Kategori("004", "Dairy Products", "Cheeses");
        Kategori lima = new Kategori("005", "Grains/Cereals", "Breads, crackers, pasta, and cereal");
        Kategori enam = new Kategori("006", "Meat/Poultry", "Prepared meats");
        Kategori tujuh = new Kategori("007", "Produce", "Dried fruit and bean curd");
        Kategori delapan = new Kategori("008", "Seafood", "Seaweed and fish");
        List<Kategori> daftarKategori = Arrays.asList(satu, dua, tiga, empat, lima, enam, tujuh, delapan);

        Toko tokoSatu = new Toko("001","Grandma Kellys Homestead","Regina Murphy","707 Oxford Rd.","Ann Arbor","08573456789","48104");
        Toko tokoDua = new Toko("002","Bigfoot Breweries","Cheryl Saylor","3400 - 8th Avenue Suite 210","Bend","089967457382","97101");
        List<Toko> listToko = Arrays.asList(tokoSatu, tokoDua);

        Produk produk1 = new Produk("001","Chais",new BigDecimal(18000),200,satu,tokoDua, daftarKategori);
        Produk produk2 = new Produk("002","AniseedSyrup",new BigDecimal(10000),12,dua,tokoSatu, daftarKategori);
        Produk produk3 = new Produk("003","Ikur",new BigDecimal(31000),12,delapan,tokoDua, daftarKategori);
        List<Produk> listProduk = Arrays.asList(produk1, produk2, produk3);

        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(listProduk));
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=daftar-produk.pdf");

        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }
}
