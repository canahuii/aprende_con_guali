package com.guali.tutor.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class HistorialDAO {

    // Registra el inicio o fin de una sesión
    public static void registrarSesion(String nombreLeccion, LocalDateTime inicio, LocalDateTime fin, String resultado) throws SQLException {
        String sql = """
            INSERT INTO historial_sesion (nombre_leccion, fecha_inicio, fecha_fin, resultado)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombreLeccion);
            stmt.setTimestamp(2, Timestamp.valueOf(inicio));
            stmt.setTimestamp(3, fin != null ? Timestamp.valueOf(fin) : null);
            stmt.setString(4, resultado);
            stmt.executeUpdate();
        }
    }
}