package com.ceiba.cliente.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Cliente {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_CLIENTE = "Se debe ingresar el nombre del cliente";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION_CLIENTE = "Se debe ingresar la fecha de creación del cliente";

    private Long id;
    private String nombreCliente;
    private int tipoCliente;
    private LocalDateTime fechaCreacion;


    public Cliente(Long id, String nombreCliente, int tipoCliente, LocalDateTime fechaCreacionCliente) {
        validarObligatorio(nombreCliente, SE_DEBE_INGRESAR_EL_NOMBRE_DE_CLIENTE);
        validarObligatorio(fechaCreacionCliente, SE_DEBE_INGRESAR_LA_FECHA_CREACION_CLIENTE);
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.tipoCliente = tipoCliente;
        this.fechaCreacion = fechaCreacionCliente;
    }

}
