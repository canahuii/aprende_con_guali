package com.guali.guali_backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "lecciones")
public class Leccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descripcion;

    @Column(name = "codigo_inicial", columnDefinition = "TEXT")
    @JsonProperty("contenidoMarkdown") // <--- ¡Esto sincroniza con MainController!
    private String codigoInicial;

    private String objetivo;

    public Leccion() {
    }

    public Leccion(String titulo, String codigoInicial, String objetivo) {
        this.titulo = titulo;
        this.codigoInicial = codigoInicial;
        this.objetivo = objetivo;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getCodigoInicial() { return codigoInicial; }
    public void setCodigoInicial(String codigoInicial) { this.codigoInicial = codigoInicial; }

    public String getObjetivo() { return objetivo; }
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }
}