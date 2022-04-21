package com.ceiba.cliente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ServicioCrearClienteTest {

    @Test
    @DisplayName("Deberia lanzar una exepecion cuando la fecha de la creacion del cliente es null")
    void deberiaLanzarUnaExepcionCuandoFechaClienteEsNula() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conFechaCreacionCliente(null).conIdCliente(1L);
        // act - assert
        BasePrueba.assertThrows(clienteTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de creación del cliente");
    }

    @Test
    @DisplayName("Deberia lanzar una exepecion cuando el nombre del cliente es null")
    void deberiaLanzarUnaExepcionCuandoNombreClienteEsNula() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conNombreCliente(null).conIdCliente(1L);
        // act - assert
        BasePrueba.assertThrows(clienteTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del cliente");
    }



}
