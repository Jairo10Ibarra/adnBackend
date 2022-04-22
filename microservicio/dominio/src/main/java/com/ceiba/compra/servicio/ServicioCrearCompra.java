package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearCompra {

    static final String EXISTE_UNA_COMPRA_CON_ESE_ID_EN_EL_SISTEMA = "la compra ya existe en el sistema";
    static final int ES_CLIENTE_ANTIGUO = 10;
    static final int ES_CLIENTE_NUEVO = 11;

    private final RepositorioCompra repositorioCompra;


    public ServicioCrearCompra(RepositorioCompra repositorioCompra) {
        this.repositorioCompra = repositorioCompra;

    }

    public Long ejecutar(Compra compra) {
        validarExistenciaCompra(compra);
        return this.repositorioCompra.crearCompra(compra);
    }

    private void validarExistenciaCompra(Compra compra) {
        boolean existe = this.repositorioCompra.existe(compra.getId());
        if (existe) {
            throw new ExcepcionDuplicidad(EXISTE_UNA_COMPRA_CON_ESE_ID_EN_EL_SISTEMA);
        }
    }
}
