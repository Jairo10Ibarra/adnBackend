package com.ceiba.cliente.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoCliente {

    private Long id;
    private String nombre;
    private int  tipoCliente;
    private LocalDateTime fechaCreacion;

}
