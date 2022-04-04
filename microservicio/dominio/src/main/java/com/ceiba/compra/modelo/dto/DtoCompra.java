package com.ceiba.compra.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoCompra {
    private Long idCompra;
    private double precio;
    private int idCliente;
    private LocalDateTime fechaCompra;

}
