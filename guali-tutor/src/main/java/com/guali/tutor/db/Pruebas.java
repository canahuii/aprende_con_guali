package com.guali.tutor.db;

import com.guali.tutor.controller.MainController;
import com.guali.tutor.form.MainForm;

import javax.swing.*;

public class Pruebas {

    public static void main(String[] args) {
        try (var conn = com.guali.tutor.db.ConexionBD.obtenerConexion()) {
            System.out.println("¡Conexión exitosa a MariaDB!");
        } catch (Exception e) {
            System.err.println("Error al conectar a MariaDB: " + e.getMessage());
        }
    }
}
