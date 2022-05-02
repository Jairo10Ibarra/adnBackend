package com.ceiba.compra.comando.fabrica;

import com.ceiba.compra.ComandoCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import org.springframework.stereotype.Component;

@Component
public class FabricaCompra {

    public Compra crearCompra(ComandoCompra comandoCompra) {
        return new Compra(
                comandoCompra.getId(),
                comandoCompra.getPrecio(),
                comandoCompra.getIdCliente(),
                comandoCompra.getFechaCompra()
        );
    }


}
