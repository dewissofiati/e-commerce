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
public class KonfirmasiController {

    @GetMapping("/konfirmasi")
    public void exampleReport(HttpServletResponse response) throws JRException, IOException {
        InputStream jasperStream = this.getClass().getResourceAsStream("/jasper/Konfirmasi.jasper");
        Map<String, Object> params = new HashMap<>();
        Konsumen konsumenSatu = new Konsumen("001", "Dewi Syarah", "Jl Baturaden IX No.16A", "40286", "Bandung", "08122044290", "dewissofiati@gmail.com");
        Kategori satu = new Kategori("001", "Beverages", "Soft drinks, coffees, teas, beers, and ales");
        List<Kategori> daftarKategori = Arrays.asList(satu);
        Toko tokoDua = new Toko("002","Bigfoot Breweries","Cheryl Saylor","3400 - 8th Avenue Suite 210","Bend","089967457382","97101");
        Produk produk1 = new Produk("001","Chais",new BigDecimal(18000),200,satu,tokoDua, daftarKategori);
        Pemesanan pemesanan = new Pemesanan("001",konsumenSatu,produk1,tokoDua,2,new BigDecimal(20000),new BigDecimal(40000));
        Pengirim pengirim1 = new Pengirim("001","J&T Express","089120934758", new BigDecimal(11000), "3 hari");
        Pembayaran pembayaran1 = new Pembayaran("001","Transfer Bank",new BigDecimal(0),"Pembayaran-> Lain-lain-> Belanja Online-> Kode Pembayaran-> Tranfer");
        DetailPemesanan detailPemesanan = new DetailPemesanan("001",pemesanan,produk1,tokoDua,5,new BigDecimal(40000),new BigDecimal(11000),pengirim1,pembayaran1,new BigDecimal(211000),true);

        Konfirmasi konfirm1 = new Konfirmasi("001",konsumenSatu,detailPemesanan,new BigDecimal(211000),pembayaran1,"Dewi Syarah", LocalDate.of(2018,12,03),true);
        List<Konfirmasi> listKonfirmasi = Arrays.asList(konfirm1);

        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(listKonfirmasi));
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=daftar-detail-pemesanan.pdf");

        final OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }
}
