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
    @ManyToOne
    @JoinColumn(name = "id_pemesanan", nullable = false)
    private Pemesanan pemesanan;
    @ManyToOne
    @JoinColumn(name = "id_produk", nullable = false)
    private Produk produk;
    @Column(name = "kuantiti", nullable = false)
    private Integer kuantiti;
    @Column(name = "harga", nullable = false)
    private BigDecimal harga;
    @Column(name = "total", nullable = false)
    private BigDecimal total;

}
