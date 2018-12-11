package com.latihan.repository;

import com.latihan.entity.Pembayaran;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PembayaranRepository extends PagingAndSortingRepository<Pembayaran, String> {
}
