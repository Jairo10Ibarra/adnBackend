package com.ceiba.compra.servicio;

import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarCompraTest {


    @Test
    @DisplayName("Deberia eliminar la compra llamando al repositorio")
    void deberiaEliminarLaCompraLlamandoAlRepositorio() {
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        ServicioEliminarCompra servicioEliminarCompra = new ServicioEliminarCompra(repositorioCompra);

        servicioEliminarCompra.ejecutar(1l);

        Mockito.verify(repositorioCompra, Mockito.times(1)).eliminar(1l);

    }

}
