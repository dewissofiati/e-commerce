package com.latihan.api;

import com.latihan.entity.Kategori;
import com.latihan.entity.Produk;
import com.latihan.entity.Toko;
import com.latihan.service.ProdukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/produk")
public class ProdukApi {

    @Autowired
    private ProdukService service;

    @GetMapping("/list")
    public Page<Produk> pagination(Pageable page){
        return service.paginate(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produk> findById(@PathVariable("id") String id){
        Optional<Produk> produkOptional = service.findById(id);
        if(produkOptional.isPresent())
            return ResponseEntity.ok(produkOptional.get());
        else
            return ResponseEntity.noContent().build();
    }

    @PutMapping("/save")
    public ResponseEntity<Produk> update(@RequestBody Produk value){
        Produk produk = service.save(value);
        return ResponseEntity.ok(produk);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id_toko") String id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
