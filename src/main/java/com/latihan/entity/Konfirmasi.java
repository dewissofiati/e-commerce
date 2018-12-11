package com.latihan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

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
    @JoinColumn(name = "id_pemesanan", nullable = false)
    private Pemesanan pemesanan;
    @OneToOne
    @JoinColumn(name = "id_konsumen", nullable = false)
    private Konsumen konsumen;
    @Column(name = "total_tagihan")
    private BigDecimal totalTagihan;
    @OneToOne
    @JoinColumn(name = "id_pembayaran")
    private Pembayaran pembayaran;
    @Column(name = "no_rekening")
    private String noRekening;
    @Column(name = "rekening_atas_nama")
    private String rekeningAtasNama;
    @Column(name = "tanggal_transfer")
    private Date tglTransfer;
    @Column(name = "status_pembayaran")
    private boolean statusBayar;

}
