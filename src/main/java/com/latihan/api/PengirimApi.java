package com.latihan.api;

import com.latihan.entity.Pengirim;
import com.latihan.service.PengirimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/api/pengirim")
public class PengirimApi {

    @Autowired
    private PengirimService service;

    @GetMapping("/list")
    public Page<Pengirim> pagination(Pageable page){
        return service.paginate(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pengirim> findById(@PathVariable("id") String id){
        Optional<Pengirim> pengirimOptional = service.findById(id);
        if(pengirimOptional.isPresent())
            return ResponseEntity.ok(pengirimOptional.get());
        else
            return ResponseEntity.noContent().build();
    }

    @PostMapping("/save")
    public ResponseEntity<Pengirim> save(
            @RequestParam(required = false) String id,
            @RequestParam String nama,
            @RequestParam String noHp,
            @RequestParam BigDecimal ongkir,
            @RequestParam String waktuKirim) {
        Pengirim pengirim = service.save(new Pengirim(id, nama, noHp, ongkir, waktuKirim));
        return ResponseEntity.ok(pengirim);
    }

    @PutMapping("/save")
    public ResponseEntity<Pengirim> update(@RequestBody Pengirim value) {
        Pengirim pengirim = service.save(value);
        return ResponseEntity.ok(pengirim);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id_pengirim") String id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
