package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.compra.modelo.entidad.Compra;

import java.time.LocalDateTime;

public class CompraTestDataBuilder {

    private Long idCompra;
    private double precio;
    private int idCliente;
    private LocalDateTime fechaCompra;


    public CompraTestDataBuilder() {
        precio = 20000;
        idCliente = 1;
        fechaCompra = LocalDateTime.now();
    }

    public CompraTestDataBuilder conPrecioCompra(double precio) {
        this.precio = precio;
        return this;
    }

    public CompraTestDataBuilder conIdCompra(Long idCompra) {
        this.idCompra = idCompra;
        return this;
    }


    public CompraTestDataBuilder conFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
        return this;
    }


    public Compra build() {
            return new Compra(idCompra, precio, idCliente, fechaCompra);
    }
}
