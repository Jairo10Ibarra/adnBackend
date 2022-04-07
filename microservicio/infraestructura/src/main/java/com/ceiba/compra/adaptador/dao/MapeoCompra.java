package com.ceiba.compra.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.compra.modelo.dto.DtoCompra;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoCompra implements RowMapper<DtoCompra>, MapperResult {

    @Override
    public DtoCompra mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long idCompra = resultSet.getLong("id");
        double precio = resultSet.getDouble("precio");
        int id = resultSet.getInt("idCliente");
        LocalDateTime fechaCompra = extraerLocalDateTime(resultSet, "fecha_creacion");
        return new DtoCompra(idCompra, precio, id, fechaCompra);


    }

}
