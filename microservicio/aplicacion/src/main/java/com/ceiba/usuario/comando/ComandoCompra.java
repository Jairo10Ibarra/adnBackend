package com.ceiba.usuario.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCompra {


    private Long idCompra;
    private double precio;
    private int idCliente;
    private LocalDateTime fechaCompra;

}
