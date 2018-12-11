package com.latihan.service;

import com.latihan.entity.Pengirim;
import com.latihan.repository.PengirimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PengirimService {

    @Autowired
    PengirimRepository repository;

    @Transactional
    public Pengirim save(Pengirim p){
        return repository.save(p);
    }

    @Transactional
    public void delete(String id){
        repository.deleteById(id);
    }

    public Optional<Pengirim> findById(String id){
        return repository.findById(id);
    }

    public Iterable<Pengirim> list(){
        return repository.findAll();
    }

    public Page<Pengirim> paginate(Pageable page){
        return repository.findAll(page);
    }
}
