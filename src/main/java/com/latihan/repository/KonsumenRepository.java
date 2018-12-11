package com.latihan.repository;

import com.latihan.entity.Konsumen;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface KonsumenRepository extends PagingAndSortingRepository<Konsumen, String> {
}
