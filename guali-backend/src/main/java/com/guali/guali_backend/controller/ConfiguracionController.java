package com.guali.guali_backend.controller;

import com.guali.guali_backend.model.Configuracion;
import com.guali.guali_backend.repository.ConfiguracionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/configuracion")
@CrossOrigin(origins = "*")
public class ConfiguracionController {

    private final ConfiguracionRepository repository;

    public ConfiguracionController(ConfiguracionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<Configuracion> obtenerConfiguracion() {
        List<Configuracion> configs = repository.findAll();
        if (configs.isEmpty()) {
            return ResponseEntity.ok(new Configuracion());
        }
        return ResponseEntity.ok(configs.get(0));
    }

    @PostMapping
    public ResponseEntity<Configuracion> guardarConfiguracion(@RequestBody Configuracion configuracion) {
        List<Configuracion> configs = repository.findAll();
        if (!configs.isEmpty()) {
            Configuracion existente = configs.get(0);
            existente.setJdkPath(configuracion.getJdkPath());
            return ResponseEntity.ok(repository.save(existente));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(configuracion));
    }
}