package com.ceiba.compra.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompraTest {

    @Test
    @DisplayName("Deberia crear correctamente una compra")
    void deberiaCrearCorrectamenteUnaCompra() {
        LocalDateTime fechaCreacion = LocalDateTime.now();
        Compra compra = new CompraTestDataBuilder().conFechaCompra(fechaCreacion).conIdCompra(1L).build();
        assertEquals(1, compra.getIdCompra());
        assertEquals(20000, compra.getPrecio());
        assertEquals(1, compra.getIdCLiente());
        assertEquals(fechaCreacion, compra.getFechaCompra());
    }

    @Test
    @DisplayName("Deberia fallar sin fecha de creacion una compra")
    void deberiaFallarSinFechaCreacionCompra() {

        //Arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().conFechaCompra(null).conIdCompra(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    compraTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de creación de la compra");
    }


}

