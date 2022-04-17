package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoUsuario {
     Long id;
     String nombre;
     String clave;
     LocalDateTime fechaCreacion;

}
