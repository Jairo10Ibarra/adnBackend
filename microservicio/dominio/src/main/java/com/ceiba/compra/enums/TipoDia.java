package com.ceiba.compra.enums;

public enum TipoDia {
    SABADO("SABADO"),
    ENTRE_SEMANA("ENTRE_SEMANA"),
    DOMINGO("DOMINGO");

    String nombre;

    TipoDia(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
