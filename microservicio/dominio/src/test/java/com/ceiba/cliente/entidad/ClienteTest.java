package com.ceiba.cliente.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {


    @Test
    @DisplayName("Deberia crear correctamente el cliente")
    void deberiaCrearCorrectamenteElCliente() {

        LocalDateTime fechaCreacion = LocalDateTime.now();
        Cliente cliente = new ClienteTestDataBuilder().conFechaCreacionCliente(fechaCreacion).conIdCliente(1L).build();
        assertEquals(1, cliente.getId());
        assertEquals("jairo", cliente.getNombreCliente());
        assertEquals(10, cliente.getTipoCliente());
        assertEquals(fechaCreacion, cliente.getFechaCreacion());
    }

    @Test
    void deberiaFallarSinNombreCliente() {

        //Arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conNombreCliente(null).conIdCliente(1l);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    clienteTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del cliente");
    }

    @Test
    void deberiaFallarSinClave() {

        //Arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conFechaCreacionCliente(null).conIdCliente(1l);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    clienteTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de creación del cliente");
    }


}
