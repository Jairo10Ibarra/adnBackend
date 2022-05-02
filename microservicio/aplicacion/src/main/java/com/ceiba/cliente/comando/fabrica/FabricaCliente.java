package com.ceiba.cliente.comando.fabrica;


import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.comando.ComandoCliente;
import org.springframework.stereotype.Component;

@Component
public class FabricaCliente {

    public Cliente crearCliente(ComandoCliente comandoCliente) {
        return new Cliente(
                comandoCliente.getIdCliente(),
                comandoCliente.getNombreCliente(),
                comandoCliente.getTipoCliente(),
                comandoCliente.getFechaCreacion()
        );
    }


}
