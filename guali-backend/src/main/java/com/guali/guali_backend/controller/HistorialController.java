package com.guali.guali_backend.controller;

import com.guali.guali_backend.model.Historial;
import com.guali.guali_backend.repository.HistorialRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/historial", "/api/historial-sesion", "/api/historiales"})
@CrossOrigin(origins = "*")
public class HistorialController {

    private final HistorialRepository repository;

    public HistorialController(HistorialRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Historial>> obtenerHistorial() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Historial> registrarHistorial(@RequestBody Historial historial) {
        return ResponseEntity.ok(repository.save(historial));
    }
}