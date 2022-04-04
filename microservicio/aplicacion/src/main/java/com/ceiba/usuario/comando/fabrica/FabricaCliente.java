package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.ComandoCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import org.springframework.stereotype.Component;

@Component
public class FabricaCliente {

    public Cliente crearCliente(ComandoCliente comandoCliente) {
        return new Cliente(
                comandoCliente.getIdCliente(),
                comandoCliente.getNombreCliente(),
                comandoCliente.getTipoCliente(),
                comandoCliente.getFechaCreacionCliente()
        );
    }


}
