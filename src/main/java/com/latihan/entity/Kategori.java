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
@Table(name = "kategori")
public class Kategori {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id_kategori", nullable = false, length = 64)
    private String id;
    @Column(name = "nama", nullable = false, length = 100)
    private String nama;
    @Column(name = "deskripsi", nullable = false)
    private String deksripsi;
}
