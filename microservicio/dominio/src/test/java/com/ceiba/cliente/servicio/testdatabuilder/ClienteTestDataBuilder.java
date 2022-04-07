package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.entidad.Cliente;

import java.time.LocalDateTime;

public class ClienteTestDataBuilder {

    private Long idCliente;
    private String nombreCliente;
    private int tipoCliente;
    private LocalDateTime fechaCreacion;

    public ClienteTestDataBuilder() {
        nombreCliente = "jairo";
        tipoCliente = 10;
        fechaCreacion = LocalDateTime.now();
    }

    public ClienteTestDataBuilder conNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        return this;
    }

    public ClienteTestDataBuilder conTipoDeCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
        return this;
    }


    public ClienteTestDataBuilder conIdCliente(Long idCliente) {
        this.idCliente = idCliente;
        return this;
    }

    public ClienteTestDataBuilder conFechaCreacionCliente(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }


    public Cliente build() {
        return new Cliente(idCliente, nombreCliente, tipoCliente, fechaCreacion);
    }

}
