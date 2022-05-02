package com.ceiba.compra.serviciotestdatabuilder;

import com.ceiba.compra.ComandoCompra;

import java.time.LocalDate;

public class ComandoCompraTestDataBuilder {

    Long id;
    double precio;
    int idCliente;
    LocalDate fechaCompra;

    public ComandoCompraTestDataBuilder() {
        precio = 20000;
        idCliente = 1;
        fechaCompra = LocalDate.now();
    }


    public ComandoCompraTestDataBuilder conPrecioCompra(double precio) {
        this.precio = precio;
        return this;
    }

    public ComandoCompra build() {
        return new ComandoCompra(id, precio, idCliente, fechaCompra);
    }
}
