package com.latihan.service;

import com.latihan.entity.Produk;
import com.latihan.repository.ProdukRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProdukService {

    @Autowired
    ProdukRepository repository;

    @Transactional
    public Produk save(Produk p){
        return repository.save(p);
    }

    @Transactional
    public void delete(String id){
        repository.deleteById(id);
    }

    public Iterable<Produk> list(){
        return repository.findAll();
    }

    public Optional<Produk> findById(String id){
        return repository.findById(id);
    }

    public Page<Produk> paginate(Pageable page){
        return repository.findAll(page);
    }
}
