package com.ceiba.cliente.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoCliente {

    private Long idCliente;
    private String nombreCliente;
    private int  tipoCliente;
    private LocalDateTime fechaCreacionCliente;

}
