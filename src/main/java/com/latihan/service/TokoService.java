package com.latihan.service;

import com.latihan.entity.Toko;
import com.latihan.repository.TokoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TokoService {

    @Autowired
    TokoRepository repository;

    @Transactional
    public Toko save(Toko t){
        return repository.save(t);
    }

    @Transactional
    public void delete(String id){
        repository.deleteById(id);
    }

    public Iterable<Toko> list(){
        return repository.findAll();
    }

    public Optional<Toko> findById(String id){
        return repository.findById(id);
    }

    public Page<Toko> paginate(Pageable page){
        return repository.findAll(page);
    }
}
