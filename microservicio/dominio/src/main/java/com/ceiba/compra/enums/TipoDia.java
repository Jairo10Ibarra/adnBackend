package com.ceiba.compra.enums;

public enum TipoDia {
    FIN_DE_SEMANA("FIN_DE_SEMANA"),
    ENTRE_SEMANA("ENTRE_SEMANA"),
    FESTIVO("FESTIVO");

    String nombre;

    TipoDia(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
