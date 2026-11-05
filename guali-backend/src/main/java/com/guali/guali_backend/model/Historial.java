package com.guali.guali_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "historial_sesion")
public class Historial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_leccion", nullable = false)
    private String leccionNombre;

    @Column(name = "fecha_inicio")
    private String fechaInicio;

    @Column(name = "fecha_fin")
    private String fechaFin;

    @Column(name = "resultado")
    private String resultado;

    public Historial() {}

    public Historial(String leccionNombre, String fechaInicio, String fechaFin, String resultado) {
        this.leccionNombre = leccionNombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.resultado = resultado;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLeccionNombre() { return leccionNombre; }
    public void setLeccionNombre(String leccionNombre) { this.leccionNombre = leccionNombre; }

    public String getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(String fechaInicio) { this.fechaInicio = fechaInicio; }

    public String getFechaFin() { return fechaFin; }
    public void setFechaFin(String fechaFin) { this.fechaFin = fechaFin; }

    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }
}