package com.guali.guali_backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
public class DataSourceConfig {

    @Value("${app.datasource.mariadb.url:jdbc:mariadb://localhost:3306/bd_guali_tutor}")
    private String mariadbUrl;

    @Value("${app.datasource.mariadb.username:root}")
    private String mariadbUser;

    @Value("${app.datasource.mariadb.password:SECRET}")
    private String mariadbPassword;

    @Value("${app.datasource.h2.url:jdbc:h2:file:./data/gualidb;AUTO_SERVER=TRUE}")
    private String h2Url;

    @Value("${app.datasource.h2.username:sa}")
    private String h2User;

    @Value("${app.datasource.h2.password:}")
    private String h2Password;

    @Bean
    @Primary
    public DataSource dataSource() {
        try {
            // Establecer un timeout de 2 segundos para la prueba rápida
            DriverManager.setLoginTimeout(2);
            Connection conn = DriverManager.getConnection(mariadbUrl, mariadbUser, mariadbPassword);
            conn.close();

            System.out.println("=================================================");
            System.out.println(">>> CONEXIÓN EXITOSA A MARIADB (bd_guali_tutor)");
            System.out.println("=================================================");

            return DataSourceBuilder.create()
                    .driverClassName("org.mariadb.jdbc.Driver")
                    .url(mariadbUrl)
                    .username(mariadbUser)
                    .password(mariadbPassword)
                    .build();

        } catch (Exception e) {
            System.out.println("=================================================");
            System.out.println(">>> MARIADB NO DISPONIBLE (" + e.getMessage() + ")");
            System.out.println(">>> ACTIVANDO H2 (RESPALDO DISCO)...");
            System.out.println("=================================================");

            return DataSourceBuilder.create()
                    .driverClassName("org.h2.Driver")
                    .url(h2Url)
                    .username(h2User)
                    .password(h2Password)
                    .build();
        }
    }
}