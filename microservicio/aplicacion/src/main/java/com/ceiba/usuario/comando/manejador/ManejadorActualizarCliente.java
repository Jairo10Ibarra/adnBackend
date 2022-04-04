package com.ceiba.usuario.comando.manejador;


import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.comando.ComandoCliente;
import com.ceiba.usuario.comando.fabrica.FabricaCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.ServicioActualizarCliente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCliente implements ManejadorComando<ComandoCliente> {


    private final FabricaCliente fabricaCliente;
    private final ServicioActualizarCliente servicioActualizarCliente;

    public ManejadorActualizarCliente(FabricaCliente fabricaCliente, ServicioActualizarCliente servicioActualizarCliente) {
        this.fabricaCliente = fabricaCliente;
        this.servicioActualizarCliente = servicioActualizarCliente;
    }

    public void ejecutar(ComandoCliente comandoCliente) {
        Cliente cliente = this.fabricaCliente.crearCliente(comandoCliente);
        this.servicioActualizarCliente.ejecutar(cliente);
    }


}
