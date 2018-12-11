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
@Table(name = "pembayaran")
public class Pembayaran {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id_pembayaran", nullable = false, length = 64)
    private String id;
    @Column(name = "metode_pembayaran", nullable = false)
    private String metodePembayaran;
    @Column(name = "deskripsi", nullable = false)
    private String deskripsi;
}
