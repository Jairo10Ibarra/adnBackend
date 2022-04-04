package com.ceiba.compra.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Compra {

    private static final String SE_DEBE_INGRESAR_EL_PRECIO_DE_LA_COMPRA = "Se debe ingresar el precio del cliente";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_COMPRA = "Se debe ingresar la fecha de creación de la compra";

    private Long idCompra;
    private double precio;
    private int idCliente;
    private LocalDateTime fechaCompra;


    public Compra(Long idCompra, double precio, int idCliente, LocalDateTime fechaCompra) {
        validarObligatorio(fechaCompra, SE_DEBE_INGRESAR_LA_FECHA_COMPRA);
        validarObligatorio(precio, SE_DEBE_INGRESAR_EL_PRECIO_DE_LA_COMPRA);

        this.idCompra = idCompra;
        this.precio = precio;
        this.idCliente = idCliente;
        this.fechaCompra = fechaCompra;
    }
}
