package com.ceiba.compra.adaptador.repositorio;

import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.compra.modelo.entidad.Compra;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCompraMysql implements RepositorioCompra {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "compra", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "compra", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "compra", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "compra", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "compra", value = "existePorId")
    private static String sqlExistePorId;

    public RepositorioCompraMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crearCompra(Compra compra) {
        return this.customNamedParameterJdbcTemplate.crear(compra, sqlCrear);
    }

    @Override
    public boolean existe(Long idCompra) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idCompra", idCompra);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Compra compra) {
        this.customNamedParameterJdbcTemplate.actualizar(compra, sqlActualizar);

    }

    @Override
    public boolean existePorId(Long idCompra) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idCompra", idCompra);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId, paramSource, Boolean.class);
    }

    @Override
    public void eliminar(Long idCompra) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idCompra", idCompra);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }
}
