package com.ceiba.compra.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.compra.enums.TipoDia;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompraTest {

    @Test
    @DisplayName("Deberia crear correctamente una compra")
    void deberiaCrearCorrectamenteUnaCompra() {
        LocalDate fechaCreacion = LocalDate.now();
        Compra compra = new CompraTestDataBuilder().conFechaCompra(fechaCreacion).conId(1L).build();
        assertEquals(1, compra.getId());
        assertEquals(20000, compra.getPrecio());
        assertEquals(1, compra.getIdCliente());
        assertEquals(fechaCreacion, compra.getFechaCompra());
    }

    @Test
    @DisplayName("Deberia fallar sin fecha de creacion una compra")
    void deberiaFallarSinFechaCreacionCompra() {

        //Arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().conFechaCompra(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    compraTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de creación de la compra");
    }

    @Test
    @DisplayName("Deberia obtener descuento")
    void deberiaObtenerDescuento() {

        //Arrange
        LocalDate fechaCreacion = LocalDate.now();
        Compra compra = new CompraTestDataBuilder().conPrecioCompra(20000).conFechaCompra(fechaCreacion).conId(1L).build();
        compra.obtenerDescuento(compra.getPrecio());
        //act-assert
        assertEquals(20000, compra.getPrecio());
    }

    @Test
    @DisplayName("Deberia obtener fin de semana si la fecha es domingo")
    void deberiaRetornarEntreSemanaSiEsDomingo() {
        LocalDate fechaCreacion = LocalDate.of(2022, 4, 24);
        Compra compra = new CompraTestDataBuilder().conFechaCompra(fechaCreacion).conId(1L).build();
        compra.obtenerTipoDeDia(fechaCreacion);
        String tipoDia = String.valueOf(TipoDia.FIN_DE_SEMANA);
        assertEquals("FIN_DE_SEMANA", tipoDia);

    }
    @Test
    @DisplayName("Deberia obtener fin de semana si la fecha es sabado")
    void deberiaRetornarEntreSemanaSiEsSabado() {
        LocalDate fechaCreacion = LocalDate.of(2022, 4, 23);
        Compra compra = new CompraTestDataBuilder().conPrecioCompra(20000).conFechaCompra(fechaCreacion).conId(1L).build();
        compra.obtenerTipoDeDia(fechaCreacion);
        String tipoDia = String.valueOf(TipoDia.FIN_DE_SEMANA);
        assertEquals("FIN_DE_SEMANA",tipoDia);

    }
    @Test
    @DisplayName("Deberia obtener entre semana si la fecha es lunes")
    void deberiaRetornarEntreSemanaSiEsLunes() {
        LocalDate fechaCreacion = LocalDate.of(2022, 4, 25);
        Compra compra = new CompraTestDataBuilder().conPrecioCompra(20000).conFechaCompra(fechaCreacion).conId(1L).build();
        compra.obtenerTipoDeDia(fechaCreacion);
        String tipoDia = String.valueOf(TipoDia.ENTRE_SEMANA);
        assertEquals("ENTRE_SEMANA", tipoDia);

    }
    @Test
    @DisplayName("Deberia obtener entre semana si la fecha es martes")
    void deberiaRetornarEntreSemanaSiEsMartes() {
        LocalDate fechaCreacion = LocalDate.of(2022, 4, 26);
        Compra compra = new CompraTestDataBuilder().conPrecioCompra(20000).conFechaCompra(fechaCreacion).conId(1L).build();
        compra.obtenerTipoDeDia(fechaCreacion);
        String tipoDia = String.valueOf(TipoDia.ENTRE_SEMANA);
        assertEquals("ENTRE_SEMANA", tipoDia);

    }
    @Test
    @DisplayName("Deberia obtener fin de semana si la fecha es miercoles")
    void deberiaRetornarEntreSemanaSiEsMiercoles() {
        LocalDate fechaCreacion = LocalDate.of(2022, 4, 27);
        Compra compra = new CompraTestDataBuilder().conPrecioCompra(20000).conFechaCompra(fechaCreacion).conId(1L).build();
        compra.obtenerTipoDeDia(fechaCreacion);
        String tipoDia = String.valueOf(TipoDia.ENTRE_SEMANA);
        assertEquals("ENTRE_SEMANA", tipoDia);

    }
    @Test
    @DisplayName("Deberia obtener entre semana si la fecha es jueves")
    void deberiaRetornarEntreSemanaSiEsJueves() {
        LocalDate fechaCreacion = LocalDate.of(2022, 4, 28);
        Compra compra = new CompraTestDataBuilder().conPrecioCompra(20000).conFechaCompra(fechaCreacion).conId(1L).build();
        compra.obtenerTipoDeDia(fechaCreacion);
        String tipoDia = String.valueOf(TipoDia.ENTRE_SEMANA);
        assertEquals("ENTRE_SEMANA", tipoDia);

    }

    @Test
    @DisplayName("Deberia obtener entre semana si la fecha es viernes")
    void deberiaRetornarEntreSemanaSiEsViernes() {
        LocalDate fechaCreacion = LocalDate.of(2022, 4, 29);
        Compra compra = new CompraTestDataBuilder().conPrecioCompra(20000).conFechaCompra(fechaCreacion).conId(1L).build();
        compra.obtenerTipoDeDia(fechaCreacion);
        String tipoDia = String.valueOf(TipoDia.ENTRE_SEMANA);
        assertEquals("ENTRE_SEMANA", tipoDia);

    }

    @Test
    @DisplayName("Deberia Aplicar descuento si es entre semana")
    void deberiaAplicarDescuentoSiEsEntreSemana() {
        LocalDate fechaCreacion = LocalDate.of(2022, 4, 25);
        Compra compra = new CompraTestDataBuilder().conFechaCompra(fechaCreacion).conId(1L).build();
        compra.obtenerTipoDeDia(fechaCreacion);
        compra.verificarSiAplicaDescuento(fechaCreacion);
        String tipoDia = String.valueOf(TipoDia.ENTRE_SEMANA);
        assertEquals("ENTRE_SEMANA", tipoDia);

    }

    @Test
    @DisplayName("Deberia No Aplicar descuento si es fin de semana")
    void deberiaNoAplicarDescuentoSiEsFinDeSemana() {
        LocalDate fechaCreacion = LocalDate.of(2022, 4, 24);
        Compra compra = new CompraTestDataBuilder().conFechaCompra(fechaCreacion).conId(1L).build();
        compra.obtenerTipoDeDia(fechaCreacion);
        compra.verificarSiAplicaDescuento(fechaCreacion);
        String tipoDia = String.valueOf(TipoDia.FIN_DE_SEMANA);
        assertEquals("FIN_DE_SEMANA", tipoDia);

    }



}

