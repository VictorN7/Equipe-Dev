package com.senai.sp.projetotaiff.repository;

import com.senai.sp.projetotaiff.interfaces.*;
import com.senai.sp.projetotaiff.modal.ZeroPeca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class ZeroPecaRepository implements Interface_ZeroPeca {

    private static final String INSERIR = "INSERT INTO taiff.zeroPecas (zp_posiX, zp_posiY, zp_posiZ, zp_posiR) VALUES (?,?,?,?)";
    private static final String ALTERAR = "UPDATE taiff.zeroPecas SET zp_posiX=?, zp_posiY=?, zp_posiZ=?, zp_posiR=? WHERE id_zeropeca=?";
    private static final String BUSCAR = "SELECT id_zeropeca, zp_posiX, zp_posiY, zp_posiZ, zp_posiR FROM taiff.zeroPecas";
    private static final String BUSCAR_ID = "SELECT id_zeropeca, zp_posiX, zp_posiY, zp_posiZ, zp_posiR FROM taiff.zeroPecas WHERE id_zeropeca= ?";
    private static final String DELETAR = "DELETE FROM zeroPecas WHERE id_zeropeca=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public int inserirZeroPeca(ZeroPeca zeroPeca) {
    	
    	KeyHolder holder = new GeneratedKeyHolder();
        try {
        	jdbcTemplate.update(
                    new PreparedStatementCreator() {
                        @Override
                        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                            PreparedStatement ps = connection.prepareStatement(INSERIR, Statement.RETURN_GENERATED_KEYS);
                            ps.setFloat(1, zeroPeca.getZp_posiX());
                            ps.setFloat(2, zeroPeca.getZp_posiY());
                            ps.setFloat(3, zeroPeca.getZp_posiZ());
                            ps.setFloat(4, zeroPeca.getZp_posiR());
                            return ps;
                        }
                    }, holder);

            
            return holder.getKey().intValue();
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public List<ZeroPeca> listarTodosZeroPeca() {
        try {
            List<ZeroPeca> lista = jdbcTemplate.query(BUSCAR,
                    BeanPropertyRowMapper.newInstance(ZeroPeca.class));
            
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ZeroPeca buscarZeroPecaId(int id) {

        try {
            Object[] params = {id};

            ZeroPeca resultBuscarZeroPecaId = jdbcTemplate.queryForObject(BUSCAR_ID,
                    BeanPropertyRowMapper.newInstance(ZeroPeca.class), params);
            
            return resultBuscarZeroPecaId;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int alterarZeroPeca(int id, ZeroPeca zp) {
    	
    	KeyHolder holder = new GeneratedKeyHolder();
        try {
        	jdbcTemplate.update(
                    new PreparedStatementCreator() {
                        @Override
                        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                            PreparedStatement ps = connection.prepareStatement(ALTERAR, Statement.RETURN_GENERATED_KEYS);
                            ps.setFloat(1, zp.getZp_posiX());
                            ps.setFloat(2, zp.getZp_posiY());
                            ps.setFloat(3, zp.getZp_posiZ());
                            ps.setFloat(4, zp.getZp_posiR());
                            ps.setInt(5, id);
                            return ps;
                        }
                    }, holder);

            
            return id;
        } catch (Exception e) {
            return -1;
        }

    }
    

    @Override
    public int excluirZeroPeca(int id) {
        try {
            Object[] params = {id};

            int resultado = jdbcTemplate.update(DELETAR, params);

            return resultado;
        } catch (Exception e) {
            return -1;
        }

    }
}


