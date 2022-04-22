package com.ceiba.cliente.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Cliente {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_CLIENTE = "Se debe ingresar el nombre del cliente";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION_CLIENTE = "Se debe ingresar la fecha de creación del cliente";
    private static final String EL_NOMBRE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "El nombre debe tener una longitud mayor o igual a %s";

    private static final int LONGITUD_MINIMA_NOMBRE = 4;


    Long id;
    String nombreCliente;
    int tipoCliente;
    LocalDateTime fechaCreacion;

    public Cliente(Long id) {
        this.id = id;
    }

    public Cliente(){
        super();
    }


    public Cliente(Long id, String nombreCliente, int tipoCliente, LocalDateTime fechaCreacion) {
        validarObligatorio(nombreCliente, SE_DEBE_INGRESAR_EL_NOMBRE_DE_CLIENTE);
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION_CLIENTE);
        validarLongitud(nombreCliente, LONGITUD_MINIMA_NOMBRE, String.format(EL_NOMBRE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A, LONGITUD_MINIMA_NOMBRE));
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.tipoCliente = tipoCliente;
        this.fechaCreacion = fechaCreacion;
    }

}
