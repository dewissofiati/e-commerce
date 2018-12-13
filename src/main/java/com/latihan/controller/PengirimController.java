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
public class PengirimanController {

    @GetMapping("/controller")
    public void exampleReport(HttpServletResponse response) throws JRException, IOException {
        InputStream jasperStream = this.getClass().getResourceAsStream("/jasper/Pemesanan.jasper");
        Map<String, Object> params = new HashMap<>();
        Konsumen konSatu = new Konsumen("001", "Dewi Syarah", "Jl Baturaden IX No.16A", "40286", "Bandung", "08122044290", "dewissofiati@gmail.com");
        Konsumen konDua = new Konsumen("002","Antonio Moreno Taquería","Mataderos 2312","05023","Mexico","081224849576","antonio@gmail.com");
        List<Konsumen> listKonsumen = Arrays.asList(konSatu, konDua);

        Kategori satu = new Kategori("001", "Beverages", "Soft drinks, coffees, teas, beers, and ales");
        Kategori dua = new Kategori("002", "Condiments", "Sweet and savory sauces, relishes, spreads, and seasonings");
        Kategori tiga = new Kategori("003", "Confections", "Desserts, candies, and sweet breads");
        Kategori empat = new Kategori("004", "Dairy Products", "Cheeses");
        Kategori lima = new Kategori("005", "Grains/Cereals", "Breads, crackers, pasta, and cereal");
        Kategori enam = new Kategori("006", "Meat/Poultry", "Prepared meats");
        Kategori tujuh = new Kategori("007", "Produce", "Dried fruit and bean curd");
        Kategori delapan = new Kategori("008", "Seafood", "Seaweed and fish");

        List<Kategori> listKategori = Arrays.asList(satu, dua, tiga, empat, lima, enam, tujuh, delapan);


        Pengirim pengirim1 = new Pengirim("001","J&T Express","089120934758");
        Pengirim pengirim2 = new Pengirim("002","JNE Express","081098765432");
        Pengirim pengirim3 = new Pengirim("003","JET Express","081234567890");
        List<Pengirim> listPengirim = Arrays.asList(pengirim1, pengirim2, pengirim3);

        Pembayaran bayar1 = new Pembayaran("001","Transfer Bank","Pembayaran-> Lain-lain-> Belanja Online-> Kode Pembayaran-> Tranfer");
        Pembayaran bayar2 = new Pembayaran("002","Bayar di Indomaret","Pembayaran-> Belanja Online-> Cetak Struk-> Bayar di kasir");
        List<Pembayaran> listPembayaran = Arrays.asList(bayar1, bayar2);

        Pemesanan pemesanan = new Pemesanan("001",konSatu, LocalDate.of(2018,12,01),true,new BigDecimal(200000),pengirim1,bayar1);
        List<Pemesanan> listPemesanan = Arrays.asList(pemesanan);

        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(listPemesanan));
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=daftar-konsumen.pdf");

        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }
}
