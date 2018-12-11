package com.latihan.repository;

import com.latihan.entity.Pengirim;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PengirimRepository extends PagingAndSortingRepository<Pengirim,String> {
}
