package com.ceiba.compra.serviciotestdatabuilder;

import com.ceiba.usuario.comando.ComandoCompra;

import java.time.LocalDateTime;

public class ComandoCompraTestDataBuilder {

    Long id;
    double precio;
    int idCliente;
    LocalDateTime fechaCompra;

    public ComandoCompraTestDataBuilder() {
        precio = 20000;
        idCliente = 1;
        fechaCompra = LocalDateTime.now();
    }


    public ComandoCompraTestDataBuilder conPrecioCompra(double precio) {
        this.precio = precio;
        return this;
    }

    public ComandoCompra build() {
        return new ComandoCompra(id, precio, idCliente, fechaCompra);
    }
}
