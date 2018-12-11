package com.latihan.repository;

import com.latihan.entity.Pemesanan;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PemesananRepository extends PagingAndSortingRepository<Pemesanan, String> {
}
