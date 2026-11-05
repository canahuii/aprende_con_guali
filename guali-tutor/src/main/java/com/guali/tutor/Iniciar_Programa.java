package com.guali.tutor;

import com.guali.guali_backend.GualiBackendApplication;
import com.guali.tutor.controller.MainController;
import com.guali.tutor.form.MainForm;

import org.springframework.boot.builder.SpringApplicationBuilder;
import javax.swing.SwingUtilities;

public class Iniciar_Programa {

    public static void main(String[] args) {
        System.out.println("=============================================");
        System.out.println(">>> INICIANDO SISTEMA COMPLETO GUALI TUTOR...");
        System.out.println("=============================================");

        // 1. Desactivar modo headless globalmente para AWT/Swing
        System.setProperty("java.awt.headless", "false");

        // 2. Iniciar Backend (Spring Boot) desactivando explicitamente el modo headless
        Thread backendThread = new Thread(() -> {
            try {
                System.out.println(">>> [1/2] Levantando servidor Spring Boot (puerto 8080)...");
                new SpringApplicationBuilder(GualiBackendApplication.class)
                        .headless(false)
                        .run(args);
            } catch (Exception e) {
                System.err.println("Error al iniciar el Backend:");
                e.printStackTrace();
            }
        });
        backendThread.start();

        // 3. Esperar 12 segundos a que el servidor REST y las tablas esten listos
        System.out.println(">>> Esperando 12 segundos a que inicialice Spring Boot...");
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // 4. Iniciar la Interfaz Swing
        System.out.println(">>> [2/2] Lanzando ventana de Guali Tutor (Swing)...");
        SwingUtilities.invokeLater(() -> {
            try {
                MainForm mainForm = new MainForm();
                new MainController(mainForm);
                mainForm.setVisible(true);
                System.out.println(">>> Aplicacion Swing abierta exitosamente.");
            } catch (Exception e) {
                System.err.println("Error al levantar la interfaz Swing:");
                e.printStackTrace();
            }
        });
    }
}