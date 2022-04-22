package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ServicioCrearCompraTest {

    private static final String LA_COMPRA_YA_EXISTE = "la compra ya existe en el sistema";

    @Test
    @DisplayName("Deberia crear una compra exitosamente")
    void deberiaCrearUnaCompraExitosamente() {

        //arrange
        Compra compra = new CompraTestDataBuilder().conId(1L).build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);

        Mockito.when(repositorioCompra.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioCompra.crearCompra(Mockito.any())).thenReturn(2L);

        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra);

        // act

        Long idCompraCreada = servicioCrearCompra.ejecutar(compra);

        // assert
        assertEquals(idCompraCreada, 2L);

    }


    @Test
    @DisplayName("Deberia lanzar una exepecion cuando la fecha de la compra es null o vacia")
    void deberiaLanzarUnaExepcionCuandoFechaCompraEsVaciaONula() {
        // arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().conFechaCompra(null).conId(1L);
        // act - assert
        BasePrueba.assertThrows(compraTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de creación de la compra");
    }


    @Test
    @DisplayName("Deberia lanzar una exepecion cuando la compra exista")
    void deberiaLanzarUnaExepcionCuandoIdCompraExiste() {
        // arrange
        Compra compra = new CompraTestDataBuilder().conId(1L).build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        Mockito.when(repositorioCompra.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra),
                ExcepcionDuplicidad.class,
                LA_COMPRA_YA_EXISTE);
    }


}
