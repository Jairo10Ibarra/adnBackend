package com.ceiba.compra.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.compra.ComandoCompra;
import com.ceiba.compra.comando.fabrica.FabricaCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.servicio.ServicioActualizarCompra;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCompra implements ManejadorComando<ComandoCompra> {

    private final FabricaCompra fabricaCompra;
    private final ServicioActualizarCompra servicioActualizarCompra;


    public ManejadorActualizarCompra(FabricaCompra fabricaCompra, ServicioActualizarCompra servicioActualizarCompra) {
        this.fabricaCompra = fabricaCompra;
        this.servicioActualizarCompra = servicioActualizarCompra;
    }

    public void ejecutar(ComandoCompra comandoCompra) {
        Compra compra = this.fabricaCompra.crearCompra(comandoCompra);
        this.servicioActualizarCompra.ejecutar(compra);
    }

}
