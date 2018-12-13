package com.latihan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detail_pemesanan")
public class DetailPemesanan {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id_detail_pemesanan")
    private String id;
    @OneToOne
    @JoinColumn(name = "id_pemesanan", nullable = false)
    private Pemesanan pemesanan;
    @ManyToOne
    @JoinColumn(name = "id_produk", nullable = false)
    private Produk produk;
    @ManyToOne
    @JoinColumn(name = "id_toko", nullable = false)
    private Toko toko;
    @Column(name = "jumlah", nullable = false)
    private Integer jumlah;
    @Column(name = "harga", nullable = false)
    private BigDecimal harga;
    @Column(name = "ongkir", nullable = false)
    private BigDecimal ongkir;
    @ManyToOne
    @JoinColumn(name = "id_pengirim", nullable = false)
    private Pengirim pengirim;
    @ManyToOne
    @JoinColumn(name = "id_pembayaran", nullable = false)
    private Pembayaran pembayaran;
    @Column(name = "total", nullable = false)
    private BigDecimal total;
    @Column(name = "status_pembayaran", nullable = false)
    private Boolean status;
}
