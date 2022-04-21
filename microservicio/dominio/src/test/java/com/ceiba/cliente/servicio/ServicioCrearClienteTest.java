package com.ceiba.cliente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearClienteTest {

    private static final String EL_CLIENTE_YA_EXISTE = "El Cliente ya existe en el sistema";

    @Test
    @DisplayName("Deberia crear el cliente correctamente")
    void deberiaCrearUnClienteExitosamente() {

        //arrange
        Cliente cliente = new ClienteTestDataBuilder().conIdCliente(1L).build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);

        Mockito.when(repositorioCliente.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioCliente.crearCliente(Mockito.any())).thenReturn(2L);

        ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);

        // act

        Long idClienteCreado = servicioCrearCliente.ejecutar(cliente);

        // assert
        assertEquals(idClienteCreado, 2L);

    }

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


    @Test
    @DisplayName("Deberia lanzar una exepecion cuando el nombre del cliente exista")
    void deberiaLanzarUnaExepcionCuandoNombreClienteExiste() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().conIdCliente(1L).build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCliente.ejecutar(cliente),
                ExcepcionDuplicidad.class,
                EL_CLIENTE_YA_EXISTE);
    }


}
