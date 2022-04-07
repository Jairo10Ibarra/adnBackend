package com.ceiba.cliente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ServicioCrearClienteTest {

    @Test
    @DisplayName("Deberia lanzar una exepecion cuando la fecha de la creacion del cliente es null o vacia")
    void deberiaLanzarUnaExepcionCuandoFechaCompraEsVaciaONula() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conFechaCreacionCliente(null).conIdCliente(1L);
        // act - assert
        BasePrueba.assertThrows(clienteTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de creación del cliente");
    }

}
