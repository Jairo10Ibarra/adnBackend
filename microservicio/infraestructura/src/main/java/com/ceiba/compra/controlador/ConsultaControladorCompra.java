package com.ceiba.compra.controlador;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.consulta.ManejadorListarCompras;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/compra")
@Api(tags = {"Controlador consulta compras"})
public class ConsultaControladorCompra {


    private final ManejadorListarCompras manejadorListarCompras;

    public ConsultaControladorCompra(ManejadorListarCompras manejadorListarCompras) {
        this.manejadorListarCompras = manejadorListarCompras;
    }

    @GetMapping
    @ApiOperation("Listar Compras")
    public List<DtoCompra> listar() {
        return this.manejadorListarCompras.ejecutar();
    }


}
