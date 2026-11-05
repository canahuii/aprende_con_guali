package com.guali.tutor.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mariadb://localhost:3306/bd_guali_tutor";
    private static final String USER = "root"; // Ajusta con tu usuario
    private static final String PASSWORD = "SECRET";  // Ajusta con tu contraseña

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}