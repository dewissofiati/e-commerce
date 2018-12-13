package com.latihan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pemesanan")
public class Pemesanan {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id_pemesanan", nullable = false, length = 64)
    private String id;
    @OneToOne
    @JoinColumn(name = "id_konsumen", nullable = false)
    private Konsumen konsumen;
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
    @Column(name = "total")
    private BigDecimal total;

//    @OneToMany(mappedBy = "pemesanan")
//    private List<DetailPemesanan> details = new ArrayList<>();
}
