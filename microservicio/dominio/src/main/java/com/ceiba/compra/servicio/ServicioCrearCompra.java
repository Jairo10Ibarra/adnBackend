package com.ceiba.compra.servicio;

import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.compra.enums.TipoDia;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServicioCrearCompra {

    static final String EXISTE_UNA_COMPRA_CON_ESE_ID_EN_EL_SISTEMA = "la compra ya existe en el sistema";
    static final int ES_CLIENTE_ANTIGUO = 10;
    static final int ES_CLIENTE_NUEVO = 11;

    private final RepositorioCompra repositorioCompra;

    public ServicioCrearCompra(RepositorioCompra repositorioCompra, DaoCliente daoCliente) {
        this.repositorioCompra = repositorioCompra;
        this.daoCliente = daoCliente;
    }

    private final DaoCliente daoCliente;

    public Long ejecutar(Compra compra) {
        validarExistenciaCompra(compra);
        double precio;
        List<Compra> compras = new ArrayList<>();

        int tipoCliente = daoCliente.consultarPorId(compra.getIdCliente()).getTipoCliente();

        if (tipoCliente == ES_CLIENTE_ANTIGUO) {

            if (verificarSiAplicaDescuento(compra.getFechaCompra().toLocalDate())) {
                obtenerDescuento(compra.getPrecio());
                precio = obtenerDescuento(compra.getPrecio());
                compras.add(new Compra(compra.getId(), precio, compra.getIdCliente(), compra.getFechaCompra()));
            }
        } else if (tipoCliente == ES_CLIENTE_NUEVO) {
            precio = compra.getPrecio();
            compras.add(new Compra(compra.getId(), precio, compra.getIdCliente(), compra.getFechaCompra()));
        }
        return this.repositorioCompra.crearCompra(compra);
    }

    private Double obtenerDescuento(double precio) {
        double descuento = 0.30;
        double valorDescuento = 0;
        valorDescuento = precio * descuento;
        return valorDescuento;
    }

    private boolean verificarSiAplicaDescuento(LocalDate fecha) {
        boolean aplicaDescuento = false;
        if (!fecha.equals(TipoDia.FIN_DE_SEMANA)) {
            aplicaDescuento = true;
        }
        return aplicaDescuento;
    }


    private void validarExistenciaCompra(Compra compra) {
        boolean existe = this.repositorioCompra.existe(compra.getId());
        if (existe) {
            throw new ExcepcionDuplicidad(EXISTE_UNA_COMPRA_CON_ESE_ID_EN_EL_SISTEMA);
        }
    }
}
