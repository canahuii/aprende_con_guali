package com.guali.guali_backend.controller;

import com.guali.guali_backend.model.Leccion;
import com.guali.guali_backend.repository.LeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lecciones")
@CrossOrigin(origins = "*")
public class LeccionController {

    @Autowired
    private LeccionRepository repository;

    // 1. GET /api/lecciones (Para seleccionarLeccionDeBd y eliminarLeccionDeBd)
    @GetMapping
    public List<Leccion> obtenerTodas() {
        return repository.findAll();
    }

    // 2. POST /api/lecciones (Para importarLeccionABd - Resuelve el Status 405)
    @PostMapping
    public ResponseEntity<Leccion> guardarLeccion(@RequestBody Leccion leccion) {
        // Si ya existe una lección con ese título, la actualiza en vez de duplicarla
        var existente = repository.findByTitulo(leccion.getTitulo());
        if (existente.isPresent()) {
            Leccion l = existente.get();
            l.setCodigoInicial(leccion.getCodigoInicial());
            l.setObjetivo(leccion.getObjetivo());
            return ResponseEntity.ok(repository.save(l));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(leccion));
    }

    // 3. DELETE /api/lecciones/{id} (Para eliminarLeccionDeBd - Resuelve eliminación)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLeccion(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        return ResponseEntity.notFound().build();
    }
}