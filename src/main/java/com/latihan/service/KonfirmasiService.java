package com.latihan.service;

import com.latihan.entity.Konfirmasi;
import com.latihan.repository.KonfirmasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class KonfirmasiService {

    @Autowired
    private KonfirmasiRepository repository;

    @Transactional
    public Konfirmasi save(Konfirmasi k){
        return repository.save(k);
    }

    @Transactional
    public void delete(String id){
        repository.deleteById(id);
    }

    public Iterable<Konfirmasi> list(){
        return repository.findAll();
    }

    public Optional<Konfirmasi> findById(String id){
        return repository.findById(id);
    }

    public Page<Konfirmasi> paginate(Pageable page){
        return repository.findAll(page);
    }
}
