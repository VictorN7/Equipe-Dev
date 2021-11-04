package com.senai.sp.projetotaiff.repository;

import com.senai.sp.projetotaiff.interfaces.Interface_Posicoes;
import com.senai.sp.projetotaiff.modal.Posicoes;
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
import java.util.Collections;
import java.util.List;

@Repository
public class PosicoesRepository implements Interface_Posicoes {

    private static final String INSERIR = "INSERT INTO taiff.posicoes (posiX,posiY,posiZ,posiR,posiT,id_teste) VALUES (?,?,?,?,?,?)";
    private static final String ALTERAR = "UPDATE taiff.posicoes SET posiX=?, posiY=?, posiZ=?, posiR=?,posiT=?,id_teste=? WHERE id_posicao=?";
    private static final String BUSCAR = "SELECT id_posicao, posiX, posiY, posiZ, posiR,posiT, id_teste FROM taiff.posicoes";
    private static final String BUSCAR_ID = "SELECT id_posicao, posiX, posiY, posiZ, posiR,posiT, id_teste FROM taiff.posicoes WHERE id_posicao=?";
    private static final String DELETAR = "DELETE FROM taiff.posicoes WHERE id_posicao=?";
    private static final String DELETAR_POSI_ID_TESTE = "DELETE FROM taiff.posicoes WHERE id_teste=?";
    private static final String BUSCAR_POSICOES_IDTESTE = "SELECT id_posicao, posiX, posiY, posiZ, posiR,posiT,id_teste FROM taiff.posicoes WHERE id_teste = ?";



    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    TemperaturaRepository temperaturaRepository;

    @Override
    public Posicoes inserirPosicoes(Posicoes posicoes) {
        try {
            KeyHolder holder = new GeneratedKeyHolder();
            jdbcTemplate.update(
                    connection -> {
                        PreparedStatement ps = connection.prepareStatement(INSERIR, Statement.RETURN_GENERATED_KEYS);
                        ps.setFloat(1, posicoes.getPosiX());
                        ps.setFloat(2, posicoes.getPosiY());
                        ps.setFloat(3, posicoes.getPosiZ());
                        ps.setFloat(4, posicoes.getPosiR());
                        ps.setFloat(5,posicoes.getPosiT());
                        ps.setInt(6, posicoes.getId_teste());
                        return ps;
                    }, holder);

                    posicoes.setId_posicao(holder.getKey().intValue());

            return posicoes;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Posicoes> listarTodasPosicoes() {
        try {
            List<Posicoes> lista = jdbcTemplate.query(BUSCAR,
                    BeanPropertyRowMapper.newInstance(Posicoes.class));

            for (Posicoes posicoes : lista) {
              posicoes.setTemperaturas(temperaturaRepository.buscarTemperaturaIdPosi(posicoes.getId_posicao()));
            }
            return lista;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Posicoes buscarPosicoesId(int id) {
        try {
            Object[] params = {id};

          return jdbcTemplate.queryForObject(BUSCAR_ID,
                    BeanPropertyRowMapper.newInstance(Posicoes.class), params);


        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int alterarPosicoes(int id, Posicoes posicoes) {
        try {
            posicoes.setId_posicao(id);
            
            Object[] params = {posicoes.getPosiX(), posicoes.getPosiY(), posicoes.getPosiZ(), posicoes.getPosiR(),posicoes.getPosiT(), posicoes.getId_teste(), id};
            
          return  jdbcTemplate.update(ALTERAR, params);


        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public boolean excluirPosicoes(int id) {
        try {
            Object[] params = {id};

            jdbcTemplate.update(DELETAR, params);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean excluirPosicoesPorIdTeste(int id) {
        try {
            Object[] params = {id};

            jdbcTemplate.update(DELETAR_POSI_ID_TESTE, params);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Posicoes> buscarPosicoesIdTeste(int idTeste) {
        try {
            Object[] params = {idTeste};

           return jdbcTemplate.query(BUSCAR_POSICOES_IDTESTE,
                    BeanPropertyRowMapper.newInstance(Posicoes.class), params);


        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

}
