package com.senai.sp.projetotaiff.repository;

import com.senai.sp.projetotaiff.interfaces.Interface_Teste;
import com.senai.sp.projetotaiff.modal.Posicoes;
import com.senai.sp.projetotaiff.modal.Teste;
import com.senai.sp.projetotaiff.modal.ZeroPeca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
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

@Import({ZeroPeca.class})
@Repository
public class TesteRepository implements Interface_Teste {

    private final static String INSERIR_TESTE = "INSERT INTO testes (nome_modelo, id_zeropeca) VALUES (?,?)";
    private final static String ALTERAR = "UPDATE taiff.testes SET nome_modelo=?, id_zeropeca=? WHERE id_teste=?";
    private final static String BUSCAR = "SELECT id_teste, nome_modelo, id_zeropeca FROM testes";
    private final static String BUSCAR_ID = "SELECT id_teste, nome_modelo, id_zeropeca FROM testes WHERE id_teste = ?";
    private final static String DELETAR = "DELETE FROM testes WHERE id_teste = ?";


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    PosicoesRepository posicoesRepository;

    @Autowired
    ZeroPecaRepository zeroPecaRepository;

    @Override
    public Teste inserirTeste(Teste teste) {


        KeyHolder holder = new GeneratedKeyHolder();
        try {
            int chaveZeroPeca = zeroPecaRepository.inserirZeroPeca(teste.getZeropeca());

            if (chaveZeroPeca < 0) {
                throw new SQLException("Erro ao inserir Zero Peça!");
            }
            jdbcTemplate.update(
                    new PreparedStatementCreator() {
                        @Override
                        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                            PreparedStatement ps = connection.prepareStatement(INSERIR_TESTE, Statement.RETURN_GENERATED_KEYS);
                            ps.setString(1, teste.getNome_modelo());
                            ps.setInt(2, chaveZeroPeca);
                            return ps;
                        }
                    }, holder);

            for (Posicoes posicoes : teste.getPosicao()) {

                posicoes.setId_teste(holder.getKey().intValue());
                posicoesRepository.inserirPosicoes(posicoes);
            }
            return teste;

        } catch (Exception e) {
            System.out.println("\nNão Deu Bom\n");
            return null;
        }

    }

    @Override
    public List<Teste> listaTodosTestes() {
        try {
            List<Teste> lista = jdbcTemplate.query(BUSCAR,
                    BeanPropertyRowMapper.newInstance(Teste.class));

            for (Teste teste : lista) {

                teste.setZeropeca(zeroPecaRepository.buscarZeroPecaId(teste.getId_teste()));
                teste.setPosicao(posicoesRepository.buscarPosicoesIdTeste(teste.getId_teste()));
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public Teste buscarTesteId(int id) {
        try {
            Object[] params = {id};

            Teste teste = jdbcTemplate.queryForObject(BUSCAR_ID,
                    BeanPropertyRowMapper.newInstance(Teste.class), params);

            teste.setZeropeca(zeroPecaRepository.buscarZeroPecaId(teste.getId_teste()));
            teste.setPosicao(posicoesRepository.buscarPosicoesIdTeste(teste.getId_teste()));

            return teste;

        } catch (Exception e) {
            System.out.println("\nNão Deu Bom\n");
            return null;
        }
    }

    @Override
    public Teste alterarTeste(Teste teste, int id) {

        KeyHolder holder = new GeneratedKeyHolder();

        try {

            int zpAlterado = zeroPecaRepository.alterarZeroPeca(teste.getZeropeca().getId_zeropeca(), teste.getZeropeca());


            if (zpAlterado < 0) {

                throw new SQLException("Erro ao inserir Zero Peça!");
            }

            jdbcTemplate.update(
                    new PreparedStatementCreator() {
                        @Override
                        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                            PreparedStatement ps = connection.prepareStatement(ALTERAR, Statement.RETURN_GENERATED_KEYS);
                            ps.setString(1, teste.getNome_modelo());
                            ps.setInt(2, teste.getZeropeca().getId_zeropeca());
                            ps.setInt(3, id);
                            return ps;
                        }
                    }, holder);


            posicoesRepository.excluirPosicoesPorIdTeste(id);

            for (Posicoes posicoes : teste.getPosicao()) {
                posicoes.setId_teste(id);
                posicoesRepository.inserirPosicoes(posicoes);
            }


            return teste;
        } catch (Exception e) {
            System.out.println("\nNot good\n");
            return null;
        }

    }

    @Override
    public int excluirTeste(int id) {
        try {
            Object[] params = {id};
           return jdbcTemplate.update(DELETAR, params);

        } catch (Exception e) {
            return -1;
        }
    }

}
