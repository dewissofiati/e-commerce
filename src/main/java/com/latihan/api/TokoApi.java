package com.latihan.api;

import com.latihan.entity.Toko;
import com.latihan.service.TokoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/toko")
public class TokoApi {

    @Autowired
    private TokoService service;

    @GetMapping("/list")
    public Page<Toko> pagination(Pageable page){
        return service.paginate(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Toko> findById(@PathVariable("id") String id){
        Optional<Toko> tokoOptional = service.findById(id);
        if(tokoOptional.isPresent())
            return ResponseEntity.ok(tokoOptional.get());
        else
            return ResponseEntity.noContent().build();
    }

    @PostMapping("/save")
    public ResponseEntity<Toko> save(
            @RequestParam(required = false) String id,
            @RequestParam String namaToko,
            @RequestParam String namaPemilik,
            @RequestParam String alamat,
            @RequestParam String kota,
            @RequestParam String noHp,
            @RequestParam String kodePos){
        Toko toko = service.save(new Toko(id,namaToko,namaPemilik,alamat,kota,noHp,kodePos));
        return ResponseEntity.ok(toko);
    }

    @PutMapping("/save")
    public ResponseEntity<Toko> update(@RequestBody Toko value){
        Toko toko = service.save(value);
        return ResponseEntity.ok(toko);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id_toko") String id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
