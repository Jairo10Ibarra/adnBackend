package com.ceiba.cliente.servicio;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.cliente.modelo.entidad.Cliente;

public class ServicioActualizarCliente {

    private static final String EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA = "El cliente no existe en el sistema";

    private RepositorioCliente repositorioCliente;

    public ServicioActualizarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public void ejecutar(Cliente cliente) {
        validarExistenciaPreviaCliente(cliente);
        this.repositorioCliente.actualizar(cliente);
    }

    public void validarExistenciaPreviaCliente(Cliente cliente) {
        boolean existe = this.repositorioCliente.existePorId(cliente.getId());
        if (!existe) {
            throw new ExcepcionDuplicidad(EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }


}
