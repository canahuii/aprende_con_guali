package com.guali.guali_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "configuracion")
public class Configuracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "clave")
    private String clave;

    @Column(name = "valor")
    private String valor;

    @Column(name = "jdk_path")
    private String jdkPath;

    public Configuracion() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }

    public String getValor() { return valor; }
    public void setValor(String valor) { this.valor = valor; }

    public String getJdkPath() { return jdkPath; }
    public void setJdkPath(String jdkPath) { this.jdkPath = jdkPath; }
}