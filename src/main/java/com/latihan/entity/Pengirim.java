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
@Table(name = "pengirim")
public class Pengirim {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id_pengirim", nullable = false, length = 64)
    private String id;
    @Column(name = "nama_pengirim", nullable = false)
    private String nama;
    @Column(name = "no_hp", nullable = false)
    private String noHp;
}
