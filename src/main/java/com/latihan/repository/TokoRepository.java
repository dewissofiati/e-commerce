package com.latihan.repository;

import com.latihan.entity.Toko;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TokoRepository extends PagingAndSortingRepository<Toko,String> {
}
