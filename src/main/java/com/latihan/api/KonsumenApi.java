package com.latihan.api;

import com.latihan.entity.Konsumen;
import com.latihan.service.KonsumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/konsumen")
public class KonsumenApi {

    @Autowired
    private KonsumenService service;

    @GetMapping("/list")
    public Page<Konsumen> pagination(Pageable page){
        return service.paginate(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Konsumen> findById(@PathVariable("id") String id){
        Optional<Konsumen> konsumenOptional = service.findById(id);
        if(konsumenOptional.isPresent())
            return ResponseEntity.ok(konsumenOptional.get());
        else
            return ResponseEntity.noContent().build();
    }

    @PostMapping("/save")
    public ResponseEntity<Konsumen> save(
            @RequestParam String id,
            @RequestParam String nama,
            @RequestParam String alamat,
            @RequestParam String kodePos,
            @RequestParam String kota,
            @RequestParam String noHp,
            @RequestParam String email){
        Konsumen konsumen = service.save(new Konsumen(id, nama, alamat, kodePos, kota, noHp, email));
        return ResponseEntity.ok(konsumen);
    }

    @PutMapping("/save")
    public ResponseEntity<Konsumen> update(@RequestBody Konsumen value){
        Konsumen konsumen = service.save(value);
        return ResponseEntity.ok(konsumen);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id_konsumen") String id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
