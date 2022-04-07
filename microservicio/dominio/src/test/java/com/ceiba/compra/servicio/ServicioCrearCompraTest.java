package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ServicioCrearCompraTest {

    @Test
    @DisplayName("Deberia lanzar una exepecion cuando la fecha de la compra es null o vacia")
    void deberiaLanzarUnaExepcionCuandoFechaCompraEsVaciaONula() {
        // arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().conFechaCompra(null).conIdCompra(1L);
        // act - assert
        BasePrueba.assertThrows(compraTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de creación de la compra");
    }


}
