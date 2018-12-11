package com.latihan.service;

import com.latihan.entity.Konsumen;
import com.latihan.repository.KonsumenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class KonsumenService {

    @Autowired
    KonsumenRepository repository;

    @Transactional
    public Konsumen save(Konsumen k){
        return repository.save(k);
    }

    @Transactional
    public void delete(String id){
        repository.deleteById(id);
    }

    public Iterable<Konsumen> list(){
        return repository.findAll();
    }

    public Optional<Konsumen> findById(String id){
        return repository.findById(id);
    }

    public Page<Konsumen> paginate(Pageable page){
        return repository.findAll(page);
    }
}
