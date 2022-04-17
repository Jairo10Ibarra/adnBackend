package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.compra.servicio.testdatabuilder.DtoClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ServicioCrearCompraTest {


    @Test
    @DisplayName("Deberia lanzar una exepecion cuando la fecha de la compra es null o vacia")
    void deberiaLanzarUnaExepcionCuandoFechaCompraEsVaciaONula() {
        // arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().conFechaCompra(null).conId(1L);
        // act - assert
        BasePrueba.assertThrows(compraTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de creación de la compra");
    }

    @Test
    @DisplayName("Debe poder crear una compra")
    void deberiaPoderCrearUnaCompra() {
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        DaoCliente daoCliente = Mockito.mock(DaoCliente.class);
        DtoCliente dtoCliente = new DtoClienteTestDataBuilder().build();
        Mockito.when(daoCliente.consultarPorId(Mockito.anyInt())).thenReturn(dtoCliente);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, daoCliente);
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().conFechaEntreSeamana();
        Long respuesta = servicioCrearCompra.ejecutar(compraTestDataBuilder.build());
        assertThat(Objects.nonNull(respuesta));
    }

    @Test
    @DisplayName("Si el cliente es nuevo no tiene accesos a descuentos")
    void noDebePermitirDescuentoEnCompraDeClienteNuevo(){
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        DaoCliente daoCliente = Mockito.mock(DaoCliente.class);
        DtoCliente dtoCliente = new DtoClienteTestDataBuilder().build();
        Mockito.when(daoCliente.consultarPorId(Mockito.anyInt())).thenReturn(dtoCliente);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, daoCliente);
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().conIdCliente(dtoCliente.getTipoCliente());
        Long respuesta = servicioCrearCompra.ejecutar(compraTestDataBuilder.build());
        assertThat(Objects.nonNull(respuesta));
    }

    @Test
    @DisplayName(("Si el cliente es antiguo debe permitir el descuento"))
    void debePermitirElDescuentoEnCompraClienteAntiguo(){
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        DaoCliente daoCliente = Mockito.mock(DaoCliente.class);
        DtoCliente dtoCliente = new DtoClienteTestDataBuilder().build();
        Mockito.when(daoCliente.consultarPorId(Mockito.anyInt())).thenReturn(dtoCliente);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, daoCliente);
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().conIdCliente(dtoCliente.getTipoCliente());
        Long respuesta = servicioCrearCompra.ejecutar(compraTestDataBuilder.build());
        assertThat(Objects.nonNull(respuesta));
    }


}
