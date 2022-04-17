package com.ceiba.compra.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoCompra;
import com.ceiba.usuario.comando.manejador.ManejadorActualizarCompra;
import com.ceiba.usuario.comando.manejador.ManejadorCrearCompra;
import com.ceiba.usuario.comando.manejador.ManejadorEliminarCompra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/compra")
@Api(tags = {"Controlador comando compras"})
public class ComandoControladorCompra {
    private final ManejadorCrearCompra manejadorCrearCompra;
    private final ManejadorEliminarCompra manejadorEliminarCompra;
    private final ManejadorActualizarCompra manejadorActualizarCompra;

    @Autowired
    public ComandoControladorCompra(ManejadorCrearCompra manejadorCrearCompra, ManejadorEliminarCompra manejadorEliminarCompra, ManejadorActualizarCompra manejadorActualizarCompra) {
        this.manejadorCrearCompra = manejadorCrearCompra;
        this.manejadorEliminarCompra = manejadorEliminarCompra;
        this.manejadorActualizarCompra = manejadorActualizarCompra;
    }


    @PostMapping
    @ApiOperation("Crear Compra")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCompra comandoCompra) {
        return manejadorCrearCompra.ejecutar(comandoCompra);
    }

    @DeleteMapping(value = "/{idCompra}")
    @ApiOperation("Eliminar Compra")
    public void eliminar(@PathVariable Long idCompra) {
        manejadorEliminarCompra.ejecutar(idCompra);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Compra")
    public void actualizar(@RequestBody ComandoCompra comandoCompra, @PathVariable Long idCompra) {
        comandoCompra.setIdCompra(idCompra);
        manejadorActualizarCompra.ejecutar(comandoCompra);
    }

}
