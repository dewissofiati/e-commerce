package com.latihan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "toko")
public class Toko {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id_toko", nullable = false, length = 64)
    private String id;
    @Column(name = "nama_toko", nullable = false, length = 100)
    private String namaToko;
    @Column(name = "nama_pemilik", nullable = false, length = 100)
    private String namaPemilik;
    @Column(name = "alamat", nullable = false)
    private String alamat;
    @Column(name = "kota", nullable = false)
    private String kota;
    @Column(name = "no_hp", nullable = false)
    private String noHp;
    @Column(name = "kode_pos", nullable = false)
    private String kodePos;
}
