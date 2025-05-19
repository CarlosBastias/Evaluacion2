package com.AdoptSmile.AdoptSmile.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.AdoptSmile.AdoptSmile.Model.Raza;
import com.AdoptSmile.AdoptSmile.Service.RazaService;

@RestController
@RequestMapping("/api/v1/razas")
public class RazaController {

    @Autowired
    private RazaService razaService;

    @GetMapping
    public ResponseEntity<List<Raza>> listar() {
        List<Raza> razas = razaService.findAll();
        if (razas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(razas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Raza> buscar(@PathVariable Long id) {
        Raza raza = razaService.findById(id);
        if (raza != null) {
            return ResponseEntity.ok(raza);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarTipo/{tipo}")
    public ResponseEntity<Raza> buscarPorTipo(@PathVariable String tipo) {
        Raza raza = razaService.buscarPorTipo(tipo);
        if (raza != null) {
            return ResponseEntity.ok(raza);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Raza> guardar(@RequestBody Raza raza) {
        Raza guardada = razaService.save(raza);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Raza> actualizar(@PathVariable Long id, @RequestBody Raza raza) {
        Raza actualizada = razaService.update(id, raza);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Raza> patch(@PathVariable Long id, @RequestBody Raza raza) {
        Raza actualizada = razaService.patch(id, raza);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            razaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
