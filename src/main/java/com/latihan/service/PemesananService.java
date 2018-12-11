package com.latihan.service;

import com.latihan.entity.DetailPemesanan;
import com.latihan.entity.Pemesanan;
import com.latihan.repository.DetailPemesananRepository;
import com.latihan.repository.PemesananRepository;
import com.latihan.repository.ProdukRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PemesananService {

    @Autowired
    private ProdukRepository produkRepository;

    @Autowired
    private PemesananRepository pemesananRepository;
    @Autowired
    private DetailPemesananRepository detailPemesananRepository;

    @Transactional
    public Pemesanan save(Pemesanan p){
        return pemesananRepository.save(p);
    }

    @Transactional
    public void delete(String id){
        pemesananRepository.deleteById(id);
    }

    public Iterable<Pemesanan> list(){
        return pemesananRepository.findAll();
    }

    public Optional<Pemesanan> findById(String id){
        return pemesananRepository.findById(id);
    }

    public Page<Pemesanan> paginate(Pageable page){
        return pemesananRepository.findAll(page);
    }

//    @Transactional
//    public Pemesanan pembelian(Pemesanan pemesanan){
//        List<DetailPemesanan> details = pemesanan.getDetails();
//        pemesanan = pemesananRepository.save(pemesanan);
//        for(DetailPemesanan detail : details){
//            detail.setPemesanan(pemesanan);
//            detailPemesananRepository.save(detail);
//            produkRepository.updateKuantitiProduk(detail.getProduk().getId(), 1);
//        }
//        return pemesanan;
//    }
}
