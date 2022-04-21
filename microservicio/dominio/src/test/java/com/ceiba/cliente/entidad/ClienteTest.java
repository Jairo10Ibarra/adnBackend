package com.ceiba.cliente.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClienteTest {

    private static final String DEBE_INGRESAR_EL_TIPO_CLIENTE = "Debe ingresar el tipo del cliente.";


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
    void deberiaFallarSinFechaCreacion() {

        //Arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conFechaCreacionCliente(null).conIdCliente(1l);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    clienteTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de creación del cliente");
    }

    @Test
    void deberiaFallarSinTamañoNombreCliente() {

        //Arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conNombreCliente("123").conIdCliente(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    clienteTestDataBuilder.build();
                },
                ExcepcionLongitudValor.class, "El nombre debe tener una longitud mayor o igual a 4");
    }


}
