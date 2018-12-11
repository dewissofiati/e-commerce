package com.latihan.api;

import com.latihan.entity.Pemesanan;
import com.latihan.service.PemesananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/pemesanan")
public class PemesananApi {

    @Autowired
    private PemesananService service;

    @GetMapping("/list")
    public Page<Pemesanan> pagination(Pageable page){
        return service.paginate(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pemesanan> findById(@PathVariable("id") String id){
        Optional<Pemesanan> pemesananOptional = service.findById(id);
        if(pemesananOptional.isPresent())
            return ResponseEntity.ok(pemesananOptional.get());
        else
            return ResponseEntity.noContent().build();
    }

    @PutMapping("/save")
    public ResponseEntity<Pemesanan> update(@RequestBody Pemesanan value){
        Pemesanan pemesanan = service.save(value);
        return ResponseEntity.ok(pemesanan);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id_kategori") String id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
