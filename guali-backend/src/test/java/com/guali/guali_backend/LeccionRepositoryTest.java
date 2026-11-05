package com.guali.guali_backend;

import com.guali.guali_backend.model.Leccion;
import com.guali.guali_backend.repository.LeccionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("h2")
public class LeccionRepositoryTest {

    @Autowired
    private LeccionRepository repository;

    @Test
    void guardar_y_encontrar_por_id() {
        Leccion leccion = new Leccion("leccion-test", "# Contenido Test", "COMPILAR EXITOSO");
        Leccion guardada = repository.save(leccion);

        Optional<Leccion> encontrada = repository.findById(guardada.getId());

        assertThat(encontrada).isPresent();
        assertThat(encontrada.get().getTitulo()).isEqualTo("leccion-test");
    }

    @Test
    void actualizar_leccion() {
        Leccion leccion = new Leccion("leccion-v1", "Texto v1", "EJECUTAR EXITOSO");
        Leccion guardada = repository.save(leccion);

        guardada.setTitulo("leccion-v2");
        repository.save(guardada);

        Leccion actualizada = repository.findById(guardada.getId()).orElseThrow();
        assertThat(actualizada.getTitulo()).isEqualTo("leccion-v2");
    }

    @Test
    void eliminar_por_id() {
        Leccion leccion = new Leccion("leccion-eliminar", "Texto", "COMPILAR EXITOSO");
        Leccion guardada = repository.save(leccion);

        repository.deleteById(guardada.getId());

        assertThat(repository.findById(guardada.getId())).isEmpty();
    }
}