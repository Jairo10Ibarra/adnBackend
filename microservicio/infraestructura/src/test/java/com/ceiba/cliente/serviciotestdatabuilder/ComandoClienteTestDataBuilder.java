package com.ceiba.cliente.serviciotestdatabuilder;

import com.ceiba.usuario.comando.ComandoCliente;

import java.time.LocalDateTime;

public class ComandoClienteTestDataBuilder {


    private Long id;
    private String nombreCliente;
    private int tipoCliente;
    private LocalDateTime fechaCreacion;

    public ComandoClienteTestDataBuilder() {
        nombreCliente = "Jairo";
        tipoCliente = 10;
        fechaCreacion = LocalDateTime.now();
    }

    public ComandoClienteTestDataBuilder conNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        return this;
    }

    public ComandoCliente build() {
        return new ComandoCliente(id, nombreCliente, tipoCliente, fechaCreacion);
    }
}
