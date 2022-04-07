package com.ceiba.cliente.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoCliente implements RowMapper<DtoCliente>, MapperResult {

    @Override
    public DtoCliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombreCliente = resultSet.getString("nombreCliente");
        int tipoCliente = resultSet.getInt("tipoCliente");
        LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "fecha_creacion");
        return new DtoCliente(id, nombreCliente, tipoCliente, fechaCreacion);
    }


}
