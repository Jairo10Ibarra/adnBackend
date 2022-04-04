package com.ceiba.compra.servicio;

import com.ceiba.compra.puerto.repositorio.RepositorioCompra;

public class ServicioEliminarCompra {

    private final RepositorioCompra repositorioCompra;

    public ServicioEliminarCompra(RepositorioCompra repositorioCompra) {
        this.repositorioCompra = repositorioCompra;
    }

    public void ejecutar(Long idCompra) {
        this.repositorioCompra.eliminar(idCompra);
    }

}
