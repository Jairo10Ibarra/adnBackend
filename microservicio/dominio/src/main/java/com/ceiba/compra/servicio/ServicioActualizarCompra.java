package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarCompra {

    private static final String LA_COMPRA_NO_EXISTE_EN_EL_SISTEMA = "La compra no existe en el sistema";

    private final RepositorioCompra repositorioCompra;

    public ServicioActualizarCompra(RepositorioCompra repositorioCompra) {
        this.repositorioCompra = repositorioCompra;
    }

    public void ejecutar(Compra compra) {
        validarExistenciaPreviaCompra(compra);
        this.repositorioCompra.actualizar(compra);
    }

    private void validarExistenciaPreviaCompra(Compra compra) {
        boolean existe = this.repositorioCompra.existePorId(compra.getIdCompra());
        if (!existe) {
            throw new ExcepcionDuplicidad(LA_COMPRA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
