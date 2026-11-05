package com.guali.tutor.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConfiguracionDAO {

    // Guarda o actualiza la ruta del JDK en MariaDB
    public static void guardarJdkHome(String rutaJdk) throws SQLException {
        String sql = """
            INSERT INTO configuracion (clave, valor) 
            VALUES ('JDK_HOME', ?) 
            ON DUPLICATE KEY UPDATE valor = ?
        """;

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, rutaJdk);
            stmt.setString(2, rutaJdk);
            stmt.executeUpdate();
        }
    }

    // Lee la ruta del JDK desde MariaDB
    public static String obtenerJdkHome() throws SQLException {
        String sql = "SELECT valor FROM configuracion WHERE clave = 'JDK_HOME'";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getString("valor");
            }
        }
        return null; // Si no se ha configurado ninguna ruta
    }
}