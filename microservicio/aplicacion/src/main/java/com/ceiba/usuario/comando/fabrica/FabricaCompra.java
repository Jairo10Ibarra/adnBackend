package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.ComandoCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import org.springframework.stereotype.Component;

@Component
public class FabricaCompra {

    public Compra crearCompra(ComandoCompra comandoCompra) {
        return new Compra(
                comandoCompra.getIdCompra(),
                comandoCompra.getPrecio(),
                comandoCompra.getIdCliente(),
                comandoCompra.getFechaCompra()
        );
    }


}
