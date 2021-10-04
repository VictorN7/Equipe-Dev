package com.senai.sp.projetotaiff.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.senai.sp.projetotaiff.modal.Temperatura;

@Repository
public class TemperaturaRepository {
    private static final String BUSCAR_TEMPERATURA_IDPOSI = "select * from taiff.temperatura where id_posicao = ?";


    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Temperatura> buscarTemperaturaIdPosi(int idPosi) {
        try {
            Object[] params = {idPosi};

            List<Temperatura> listaPosicoesIdTeste = jdbcTemplate.query(BUSCAR_TEMPERATURA_IDPOSI,
                    BeanPropertyRowMapper.newInstance(Temperatura.class), params);

            return listaPosicoesIdTeste;

        } catch (Exception e) {
            return null;
        }
    }

}


