package com.ceiba.compra.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.compra.serviciotestdatabuilder.ComandoCompraTestDataBuilder;
import com.ceiba.usuario.comando.ComandoCompra;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorCompra.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorCompraTest {


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deberiaCrearUnCompra() throws Exception {

        ComandoCompra compra = new ComandoCompraTestDataBuilder().conPrecioCompra(10000).build();
        mockMvc.perform(post("/compra")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(compra)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}")
                );
    }
}
