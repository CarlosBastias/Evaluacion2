package com.AdoptSmile.AdoptSmile.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.AdoptSmile.AdoptSmile.Model.Especie;
import com.AdoptSmile.AdoptSmile.Service.EspecieService;

@RestController
@RequestMapping("/api/v1/especies")
public class EspecieController {

    @Autowired
    private EspecieService especieService;

    @GetMapping
    public ResponseEntity<List<Especie>> listar() {
        List<Especie> especies = especieService.findAll();
        if (especies.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(especies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especie> buscar(@PathVariable Long id) {
        Especie especie = especieService.findById(id);
        if (especie != null) {
            return ResponseEntity.ok(especie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Especie> guardar(@RequestBody Especie especie) {
        Especie especieGuardada = especieService.save(especie);
        return ResponseEntity.status(HttpStatus.CREATED).body(especieGuardada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especie> actualizar(@PathVariable Long id, @RequestBody Especie especie) {
        Especie actualizado = especieService.update(id, especie);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Especie> patchEspecie(@PathVariable Long id, @RequestBody Especie especie) {
        Especie actualizado = especieService.patch(id, especie);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            especieService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
