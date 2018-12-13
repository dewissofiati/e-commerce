package com.latihan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "konfirmasi")
public class Konfirmasi {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id_konfirmasi", nullable = false, length = 64)
    private String id;
    @OneToOne
    @JoinColumn(name = "id_konsumen", nullable = false)
    private Konsumen konsumen;
    @OneToOne
    @JoinColumn(name = "id_detail_pembayaran")
    private DetailPemesanan detailPemesanan;
    @Column(name = "total")
    private BigDecimal total;
    @OneToOne
    @JoinColumn(name = "id_pembayaran")
    private Pembayaran pembayaran;
    @Column(name = "atas_nama")
    private String atasNama;
    @Column(name = "tanggal_bayar")
    private LocalDate tglBayar;
    @Column(name = "status_pembayaran")
    private boolean statusBayar;
}
