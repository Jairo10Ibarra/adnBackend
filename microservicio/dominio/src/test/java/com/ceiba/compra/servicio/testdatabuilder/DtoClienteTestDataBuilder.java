package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.dto.DtoCliente;

import java.time.LocalDateTime;

public class DtoClienteTestDataBuilder {

    private Long id;
    private String nombre;
    private int tipoCliente;
    private LocalDateTime fechaCreacion;


    public DtoClienteTestDataBuilder() {
        this.id = 1L;
        this.nombre = "Alonso";
        this.tipoCliente = 10;
        this.fechaCreacion = LocalDateTime.now();
    }

    public DtoCliente build(){
        return new DtoCliente(id,nombre,tipoCliente,fechaCreacion);
    }



}
