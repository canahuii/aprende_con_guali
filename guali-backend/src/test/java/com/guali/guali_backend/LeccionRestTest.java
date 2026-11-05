package com.guali.guali_backend;

import com.guali.guali_backend.model.Leccion;
import com.guali.guali_backend.repository.LeccionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("h2")
public class LeccionRestTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private LeccionRepository repository;

    @BeforeEach
    void init() {
        repository.deleteAll();
        repository.save(new Leccion("leccion-01", "# Hola", "COMPILAR EXITOSO"));
        repository.save(new Leccion("leccion-02", "# Adios", "EJECUTAR EXITOSO"));
    }

    @Test
    void listar_devuelve_json() throws Exception {
        mockMvc.perform(get("/api/lecciones"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void crear_y_obtener() throws Exception {
        mockMvc.perform(post("/api/lecciones")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"titulo\":\"leccion-03\",\"contenidoMarkdown\":\"# Test\",\"objetivo\":\"COMPILAR CON ERROR\"}"))
                .andExpect(status().isCreated());

        mockMvc.perform(get("/api/lecciones"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }
}