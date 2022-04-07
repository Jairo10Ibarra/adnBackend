package com.ceiba.cliente.puerto.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;

import java.util.List;

public interface DaoCliente {

    /**
     * Permite listar clientes
     *
     * @return los clientes
     */
    List<DtoCliente> listar();

    /**
     * Permite consultar cliente por medio del id
     *
     * @param idCliente identificador del cliente
     * @return los clientes
     */
    DtoCliente consultarPorId(int idCliente);

}
