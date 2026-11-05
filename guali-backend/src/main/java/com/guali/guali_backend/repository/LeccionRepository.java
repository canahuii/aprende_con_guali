package com.guali.guali_backend.repository;

import com.guali.guali_backend.model.Leccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeccionRepository extends JpaRepository<Leccion, Long> {
    Optional<Leccion> findByTitulo(String titulo);
    void deleteByTitulo(String titulo);
}