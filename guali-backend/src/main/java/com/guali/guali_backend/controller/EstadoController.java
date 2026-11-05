package com.guali.guali_backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;

@RestController
@RequestMapping({"/api/estado", "/api/estados"})
@CrossOrigin(origins = "*")
public class EstadoController {

    private final DataSource dataSource;

    public EstadoController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping(value = "/bd", produces = "text/plain")
    public String obtenerBaseDatosActiva() {
        try (Connection conn = dataSource.getConnection()) {
            String url = conn.getMetaData().getURL().toLowerCase();
            String driverName = conn.getMetaData().getDriverName().toLowerCase();

            if (url.contains("mariadb") || driverName.contains("mariadb") || url.contains("mysql")) {
                return "MariaDB";
            } else {
                return "H2 (Respaldo)";
            }
        } catch (Exception e) {
            return "H2 (Respaldo)";
        }
    }
}