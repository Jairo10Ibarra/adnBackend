package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ServicioCrearCompraTest {

    private static final String LA_COMPRA_YA_EXISTE = "la compra ya existe en el sistema";


    @Test
    @DisplayName("Deberia aplicar descuento si es cliente antiguo y la fecha es entre semana")
    void deberiaAplicarDescuentoSiEsClienteAntiguoYLaFechaEsEntreSemana() {

        //arrange
        LocalDate fecha = LocalDate.of(2022,4,22);
        Compra compra = new CompraTestDataBuilder().conId(1L).conFechaCompra(fecha).build();

        ServicioCrearCompra servicioCrearCompra = Mockito.mock(ServicioCrearCompra.class);

        DaoCliente daoCliente = Mockito.mock(DaoCliente.class);

        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);

        servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, daoCliente);

        Mockito.when(daoCliente.consultarPorId(Mockito.anyInt())).thenReturn(new DtoCliente(1L,"Jairo",10, LocalDateTime.now()));

        // act

        Long idCompraCreada = servicioCrearCompra.ejecutar(compra);

        // assert
        assertEquals( 14000,compra.getPrecio());

    }

    @Test
    @DisplayName("No Deberia aplicar descuento si es cliente nuevo")
    void noDeberiaAplicarDescuentoSiEsClienteAntiguoYLaFechaEsEntreSemana() {

        //arrange
        LocalDate fecha = LocalDate.of(2022,4,22);
        Compra compra = new CompraTestDataBuilder().conId(1L).conFechaCompra(fecha).build();

        ServicioCrearCompra servicioCrearCompra = Mockito.mock(ServicioCrearCompra.class);

        DaoCliente daoCliente = Mockito.mock(DaoCliente.class);

        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);

        servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, daoCliente);

        Mockito.when(daoCliente.consultarPorId(Mockito.anyInt())).thenReturn(new DtoCliente(1L,"Jairo",11, LocalDateTime.now()));

        // act

        Long idCompraCreada = servicioCrearCompra.ejecutar(compra);

        // assert
        assertEquals( 20000,compra.getPrecio());

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
        DaoCliente daoCliente = Mockito.mock(DaoCliente.class);

        Mockito.when(repositorioCompra.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, daoCliente);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra),
                ExcepcionDuplicidad.class,
                LA_COMPRA_YA_EXISTE);
    }


}
