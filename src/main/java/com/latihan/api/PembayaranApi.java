package com.latihan.api;

import com.latihan.entity.Pembayaran;
import com.latihan.service.PembayaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/api/pembayaran")
public class PembayaranApi {

    @Autowired
    private PembayaranService service;

    @GetMapping("/list")
    public Page<Pembayaran> pagination(Pageable page){
        return service.paginate(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pembayaran> findById(@PathVariable("id") String id){
        Optional<Pembayaran> pembayaranOptional = service.findById(id);
        if(pembayaranOptional.isPresent())
            return ResponseEntity.ok(pembayaranOptional.get());
        else
            return ResponseEntity.noContent().build();
    }

    @PostMapping("/save")
    public ResponseEntity<Pembayaran> save(
            @RequestParam String id,
            @RequestParam String nama,
            @RequestParam BigDecimal biaya,
            @RequestParam String deskripsi){
        Pembayaran pembayaran = service.save(new Pembayaran(id, nama, biaya, deskripsi));
        return ResponseEntity.ok(pembayaran);
    }

    @PutMapping("/save")
    public ResponseEntity<Pembayaran> update(@RequestBody Pembayaran value){
        Pembayaran pembayaran = service.save(value);
        return ResponseEntity.ok(pembayaran);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id_pembayaran") String id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
