package com.latihan.repository;

import com.latihan.entity.Kategori;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface KategoriRepository extends PagingAndSortingRepository<Kategori, String> {
}
