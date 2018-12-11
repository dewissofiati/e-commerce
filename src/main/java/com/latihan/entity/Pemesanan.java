package com.latihan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
    @ManyToOne
    @JoinColumn(name = "id_konsumen", nullable = false)
    private Konsumen konsumen;
    @Column(name = "tanggal_pesan", nullable = false)
    private Date tglPesan;
    @Column(name = "status_pembayaran")
    private boolean statusBayar;
    @Column(name = "total_bayar")
    private BigDecimal totalBayar;
    @ManyToOne
    @JoinColumn(name = "id_pengirim", nullable = false)
    private Pengirim pengirim;
    @ManyToOne
    @JoinColumn(name = "id_pembayaran", nullable = false)
    private Pembayaran pembayaran;
//    @OneToMany(mappedBy = "pemesanan")
//    private List<DetailPemesanan> details = new ArrayList<>();
}
