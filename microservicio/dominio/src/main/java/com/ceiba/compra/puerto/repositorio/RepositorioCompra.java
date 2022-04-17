package com.ceiba.compra.puerto.repositorio;

import com.ceiba.compra.modelo.entidad.Compra;

public interface RepositorioCompra {

    /**
     * Permite crear una compra
     *
     * @param compra
     * @return el id generado
     */
    Long crearCompra(Compra compra);


    /**
     * Permite validar si existe una compra con un id
     *
     * @param id
     * @return si existe o no
     */
    boolean existe(Long id);

    /**
     * Permite actualizar un compra
     *
     * @param compra
     */
    void actualizar(Compra compra);

    /**
     * Permite validar si existe un usuario con un nombre excluyendo un id
     *
     * @return si existe o no
     */
    boolean existePorId(Long id);

    /**
     * Permite eliminar una compra por id
     *
     * @param id
     */
    void eliminar(Long id);

}
