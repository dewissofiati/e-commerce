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
@Table(name = "konsumen")
public class Konsumen {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id_konsumen", nullable = false, length = 64)
    private String id;
    @Column(name = "nama_konsumen", nullable = false, length = 100)
    private String nama;
    @Column(name = "alamat", nullable = false)
    private String alamat;
    @Column(name = "kode_pos", nullable = false)
    private String kodePos;
    @Column(name = "kota")
    private String kota;
    @Column(name = "no_hp")
    private String noHp;
    @Column(name = "email")
    private String email;

}
