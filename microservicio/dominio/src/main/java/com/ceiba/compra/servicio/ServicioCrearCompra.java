package com.ceiba.compra.servicio;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearCompra {

    static final String EXISTE_UNA_COMPRA_CON_ESE_ID_EN_EL_SISTEMA = "la compra ya existe en el sistema";
    static final int ES_CLIENTE_ANTIGUO = 10;
    static final int ES_CLIENTE_NUEVO = 11;

    private final RepositorioCompra repositorioCompra;
    private final DaoCliente daoCliente;


    public ServicioCrearCompra(RepositorioCompra repositorioCompra, DaoCliente daoCliente) {
        this.repositorioCompra = repositorioCompra;
        this.daoCliente = daoCliente;
    }

    public Long ejecutar(Compra compra) {
        validarExistenciaCompra(compra);

        DtoCliente dtoCliente = daoCliente.consultarPorId(compra.getIdCliente());
        if (dtoCliente.getTipoCliente() == ES_CLIENTE_ANTIGUO && compra.verificarSiAplicaDescuento(compra.getFechaCompra())) {
            compra.obtenerDescuento(compra.getPrecio());
            return this.repositorioCompra.crearCompra(compra);
        }
        if (dtoCliente.getTipoCliente()  == ES_CLIENTE_NUEVO) {
            return this.repositorioCompra.crearCompra(compra);
        }
        return this.repositorioCompra.crearCompra(compra);
    }

    public void validarExistenciaCompra(Compra compra) {
        boolean existe = this.repositorioCompra.existe(compra.getId());
        if (existe) {
            throw new ExcepcionDuplicidad(EXISTE_UNA_COMPRA_CON_ESE_ID_EN_EL_SISTEMA);
        }
    }
}
