package com.ceiba.compra.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;

@Getter
public class Compra {

    static final String EL_ID_COMPRA_NO_PUEDE_SER_CERO = "El id de la compra no puede ser cero";
    private static final String EL_PRECIO_DE_LA_COMPRA_DEBE_SER_MAYOR_A_CERO = "El precio de la compra debe ser mayor a cero";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_COMPRA = "Se debe ingresar la fecha de creación de la compra";

    Long id;
    double precio;
    int idCliente;
    LocalDateTime fechaCompra;


    public Compra(Long id, double precio, int idCliente, LocalDateTime fechaCompra) {
        validarObligatorio(fechaCompra, SE_DEBE_INGRESAR_LA_FECHA_COMPRA);
        validarPositivo(precio, EL_PRECIO_DE_LA_COMPRA_DEBE_SER_MAYOR_A_CERO);

        this.id = id;
        this.precio = precio;
        this.idCliente = idCliente;
        this.fechaCompra = fechaCompra;
    }
}
