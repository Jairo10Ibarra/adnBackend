package com.ceiba.compra.modelo.entidad;

import com.ceiba.compra.enums.TipoDia;
import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDate;
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

    public Double obtenerDescuento(double precio) {
        double descuento = 0.30;
        double valorDescuento = 0;
        valorDescuento = precio * descuento;
        return valorDescuento;
    }

    public TipoDia obtenerTipoDeDia(LocalDate fecha) {
        if (fecha.getDayOfWeek().equals(DayOfWeek.SATURDAY) && fecha.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            return TipoDia.ENTRE_SEMANA;
        }

        if (fecha.getDayOfWeek().equals(DayOfWeek.MONDAY) && fecha.getDayOfWeek().equals(DayOfWeek.TUESDAY) &&
                fecha.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
            return TipoDia.ENTRE_SEMANA;
        }
        return TipoDia.FESTIVO;
    }

    public boolean verificarSiAplicaDescuento(LocalDate fecha) {
        boolean aplicaDescuento = false;
        if (obtenerTipoDeDia(fecha).equals(TipoDia.ENTRE_SEMANA)) {
            aplicaDescuento = true;
        }
        return aplicaDescuento;
    }

}
