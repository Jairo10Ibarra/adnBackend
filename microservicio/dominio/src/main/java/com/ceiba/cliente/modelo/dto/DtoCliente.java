package com.ceiba.cliente.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoCliente {

     Long id;
     String nombre;
     int tipoCliente;
     LocalDateTime fechaCreacion;

}
