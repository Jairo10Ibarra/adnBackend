package com.ceiba.compra.servicio;

import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.compra.modelo.entidad.Compra;

public class ServicioCrearCompra {

    private static final String EXISTE_UNA_COMPRA_CON_ESE_ID_EN_EL_SISTEMA = "la compra ya existe en el sistema";

    private final RepositorioCompra repositorioCompra;

    public ServicioCrearCompra(RepositorioCompra repositorioCompra) {
        this.repositorioCompra = repositorioCompra;
    }

    public Long ejecutar(Compra compra) {
        validarExistenciaCompra(compra);
        return this.repositorioCompra.crearCompra(compra);
    }

    public void validarExistenciaCompra(Compra compra) {
        boolean existe = this.repositorioCompra.existe(compra.getIdCompra());
        if (existe) {
            throw new ExcepcionDuplicidad(EXISTE_UNA_COMPRA_CON_ESE_ID_EN_EL_SISTEMA);
        }

    }

}
