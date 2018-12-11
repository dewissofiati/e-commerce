package com.latihan.service;

import com.latihan.entity.Pembayaran;
import com.latihan.repository.PembayaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PembayaranService {

    @Autowired
    private PembayaranRepository repository;

    @Transactional
    public Pembayaran save(Pembayaran p){
        return repository.save(p);
    }

    @Transactional
    public void delete(String id){
        repository.deleteById(id);
    }

    public Iterable<Pembayaran> findAll(){
        return repository.findAll();
    }

    public Optional<Pembayaran> findById(String id){
        return repository.findById(id);
    }

    public Page<Pembayaran> paginate(Pageable page){
        return repository.findAll(page);
    }
}
