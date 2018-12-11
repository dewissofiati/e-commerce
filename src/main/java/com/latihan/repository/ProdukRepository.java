package com.latihan.repository;

import com.latihan.entity.Produk;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProdukRepository extends PagingAndSortingRepository<Produk, String> {

    @Modifying
    @Query("UPDATE from Produk set kuantiti = stock - ?2 where id = ?1")
    int updateKuantitiProduk(String id, Integer kuantiti);
}
