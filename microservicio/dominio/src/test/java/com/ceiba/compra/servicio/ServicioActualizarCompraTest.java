package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarCompraTest {


    @Test
    @DisplayName("Deberia validar la existencia previa de una compra")
    void deberiaValidarLaExistenciaPreviaDeUnaCompra() {
        // arrange
        Compra compra = new CompraTestDataBuilder().conIdCompra(1L).build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        Mockito.when(repositorioCompra.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarCompra servicioActualizarCompra = new ServicioActualizarCompra(repositorioCompra);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCompra.ejecutar(compra), ExcepcionDuplicidad.class, "La compra no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Compra compra = new CompraTestDataBuilder().conIdCompra(1L).build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        Mockito.when(repositorioCompra.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarCompra servicioActualizarCompra = new ServicioActualizarCompra(repositorioCompra);
        // act
        servicioActualizarCompra.ejecutar(compra);
        //assert
        Mockito.verify(repositorioCompra, Mockito.times(1)).actualizar(compra);

    }

}
