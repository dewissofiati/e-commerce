package com.latihan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produk")
public class Produk {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id_produk", nullable = false, length = 64)
    private String id;
    @Column(name = "nama", nullable = false, length = 100)
    private String nama;
    @Column(name = "harga", nullable = false)
    private BigDecimal harga;
    @Column(name = "kuantiti")
    private Integer kuantiti;
    @ManyToOne
    @JoinColumn(name = "id_kategori")
    private Kategori kategori;
    @ManyToOne
    @JoinColumn(name = "id_toko")
    private Toko toko;
    @OneToMany
    @JoinTable(
            name = "kategori_produk",
            joinColumns = @JoinColumn(name = "id_produk", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_kategori", nullable = false)
    )
    private List<Kategori> daftarKategori = new ArrayList<>();
}
