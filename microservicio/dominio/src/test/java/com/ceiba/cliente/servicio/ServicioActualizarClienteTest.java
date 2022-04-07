package com.ceiba.cliente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarClienteTest {


    @Test
    @DisplayName("Deberia validar la existencia previa del cliente")
    void deberiaValidarExistenciaPreviaDelCliente(){
        Cliente cliente = new ClienteTestDataBuilder().conIdCliente(1L).build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarCliente servicioActualizarCliente = new ServicioActualizarCliente(repositorioCliente);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCliente.ejecutar(cliente), ExcepcionDuplicidad.class,"El cliente no existe en el sistema");    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().conIdCliente(1L).build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarCliente servicioActualizarCliente  = new ServicioActualizarCliente(repositorioCliente);
        // act
        servicioActualizarCliente.ejecutar(cliente);
        //assert
        Mockito.verify(repositorioCliente,Mockito.times(1)).actualizar(cliente);
    }


}
