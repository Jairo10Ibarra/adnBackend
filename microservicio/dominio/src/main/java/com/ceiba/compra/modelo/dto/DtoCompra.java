package com.ceiba.compra.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoCompra {
     Long idCompra;
     double precio;
     int idCliente;
     LocalDateTime fechaCompra;

}
