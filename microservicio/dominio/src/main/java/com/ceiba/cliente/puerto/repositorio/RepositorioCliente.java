package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;

public interface RepositorioCliente {

    /**
     * Permite crear un cliente
     *
     * @param cliente
     * @return el id generado
     */
    Long crearCliente(Cliente cliente);

    /**
     * Permite validar si existe un cliente con un nombre
     *
     * @param nombreCliente
     * @return si existe o no
     */
    boolean existe(String nombreCliente);

    /**
     * Permite actualizar un cliente
     *
     * @param cliente
     */
    void actualizar(Cliente cliente);

    /**
     * Permite validar si existe un cliente con un nombre excluyendo un id
     *
     * @return si existe o no
     */
    boolean existePorId(Long idCliente);

    /**
     * Permite eliminar un cliente
     *
     * @param idCliente
     */
    void eliminar(Long idCliente);

}


