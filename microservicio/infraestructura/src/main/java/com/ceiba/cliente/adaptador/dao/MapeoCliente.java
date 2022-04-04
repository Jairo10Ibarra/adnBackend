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
        Long idCliente = resultSet.getLong("id_cliente");
        String nombreCliente = resultSet.getString("nombre_cliente");
        int tipoCliente = resultSet.getInt("tipo_cliente");
        LocalDateTime fechaCreacionCliente = extraerLocalDateTime(resultSet, "fecha_creacion");
        return new DtoCliente(idCliente, nombreCliente, tipoCliente, fechaCreacionCliente);
    }


}
