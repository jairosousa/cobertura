package io.jnsdev.cobertura.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jnsdev.cobertura.model.Contato;
import io.jnsdev.cobertura.repository.ContatoRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @Autor Jairo Nascimento
 * @Created 23/11/2021 - 06:52
 */
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContatoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ContatoRepository contatoRepository;

    Contato contato;

    @BeforeEach
    void setUp() {
        contato = new Contato();
        contato.setNome("Fulano");
        contato.setIdade(25);
    }

    @Test
    @DisplayName("Deve retornar 201 um contato salvo")
    @Order(1)
    void save() throws Exception {

        String json = objectMapper.writeValueAsString(contato);

        mockMvc.perform(post("/contacts")
                .contentType("application/json")
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("nome").value(contato.getNome()))
                .andExpect(jsonPath("idade").value(contato.getIdade()));
    }

    @Test
    @DisplayName("Deve retornar 200 list ContatoRef")
    @Order(2)
    void getAllContatos() throws Exception{
        MockHttpServletRequestBuilder request = get("/contacts")
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("_embedded").isNotEmpty());
    }

    @Test
    @DisplayName("Não deve retornar 200 list ContatoRef")
    @Order(4)
    void getNotAllContatos() throws Exception{
        contatoRepository.deleteAll();
        MockHttpServletRequestBuilder request = get("/contacts")
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isNotFound());
    }

    @Test
    @Order(3)
    @DisplayName("Deve retornar um contato")
    void getStudentById() throws Exception{
        MockHttpServletRequestBuilder request = get("/contacts/1")
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("nome").value(contato.getNome()))
                .andExpect(jsonPath("idade").value(contato.getIdade()))
                .andExpect(jsonPath("_links").isNotEmpty());
    }

    @Test
    @Order(5)
    @DisplayName("Não deve retornar um contato")
    void getNotStudentById() throws Exception{
        MockHttpServletRequestBuilder request = get("/contacts/1")
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isNotFound());
    }
}