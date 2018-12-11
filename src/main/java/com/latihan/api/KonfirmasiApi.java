package com.latihan.api;

import com.latihan.entity.Konfirmasi;
import com.latihan.service.KonfirmasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/konfirmasi")
public class KonfirmasiApi {

    @Autowired
    private KonfirmasiService service;

    @GetMapping("/list")
    public Page<Konfirmasi> pagination(Pageable page){
        return service.paginate(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Konfirmasi> findById(@PathVariable("id") String id){
        Optional<Konfirmasi> konfirmasiOptional = service.findById(id);
        if(konfirmasiOptional.isPresent())
            return ResponseEntity.ok(konfirmasiOptional.get());
        else
            return ResponseEntity.noContent().build();
    }

    @PutMapping("/save")
    public ResponseEntity<Konfirmasi> update(@RequestBody Konfirmasi value){
        Konfirmasi konfirmasi = service.save(value);
        return ResponseEntity.ok(konfirmasi);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id_konfirmasi") String id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
