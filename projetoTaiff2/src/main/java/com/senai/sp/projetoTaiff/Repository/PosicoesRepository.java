package com.senai.sp.projetoTaiff.Repository;

import com.senai.sp.projetoTaiff.Interface.*;
import com.senai.sp.projetoTaiff.Modal.Posicoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PosicoesRepository implements Interface_Posicoes {

    private static final String INSERIR = "INSERT INTO taiff.posicoes (posiX,posiY,posiZ,posiR,id_teste) VALUES (?,?,?,?,?)";
    private static final String ALTERAR = "UPDATE taiff.posicoes SET posiX=?, posiY=?, posiZ=?, posiR=?, id_teste=? WHERE id_posicao=?";
    private static final String BUSCAR = "SELECT id_posicao, posiX, posiY, posiZ, posiR, id_teste FROM taiff.posicoes";
    private static final String BUSCAR_ID = "SELECT id_posicao, posiX, posiY, posiZ, posiR, id_teste FROM taiff.posicoes WHERE id_posicao=?";
    private static final String DELETAR = "DELETE FROM taiff.posicoes WHERE id_posicao=?";
    private static final String DELETAR_POSI_ID_TESTE = "DELETE FROM taiff.posicoes WHERE id_teste=?";
    private static final String BUSCAR_POSICOES_IDTESTE = "SELECT id_posicao, posiX, posiY, posiZ, posiR, id_teste FROM taiff.posicoes WHERE id_teste = ?";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean inserirPosicoes(Posicoes posicoes) {
        try {
            jdbcTemplate.update(INSERIR, posicoes.getPosiX(), posicoes.getPosiY(), 
            		posicoes.getPosiZ(), posicoes.getPosiR(),posicoes.getId_teste());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Posicoes> listarTodasPosicoes() {
        try {
            List<Posicoes> lista = jdbcTemplate.query(BUSCAR,
                    BeanPropertyRowMapper.newInstance(Posicoes.class));
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Posicoes buscarPosicoesId(int id) {
        try {
            Object[] params = {id};

            Posicoes posicoesResult = jdbcTemplate.queryForObject(BUSCAR_ID,
                    BeanPropertyRowMapper.newInstance(Posicoes.class), params);

            return posicoesResult;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int alterarPosicoes(int id, Posicoes posicoes) {
        try {
            posicoes.setId_posicao(id);
            
            Object[] params = {posicoes.getPosiX(), posicoes.getPosiY(), posicoes.getPosiZ(), posicoes.getPosiR(), posicoes.getId_teste(), id};
            
            int resultado = jdbcTemplate.update(ALTERAR, params);

            return resultado;
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

            List<Posicoes> listaPosicoesIdTeste = jdbcTemplate.query(BUSCAR_POSICOES_IDTESTE,
                    BeanPropertyRowMapper.newInstance(Posicoes.class), params);

            return listaPosicoesIdTeste;

        } catch (Exception e) {
            return null;
        }
    }

}
