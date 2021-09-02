package com.senai.sp.projetoTaiff.Interface;

import com.senai.sp.projetoTaiff.Modal.Posicoes;

import java.util.List;

public interface Interface_Posicoes {

    boolean inserirPosicoes(Posicoes posicoes);
    List<Posicoes> listarTodasPosicoes();
    Posicoes buscarPosicoesId(int id);
    int alterarPosicoes(int id, Posicoes posicoes);
    boolean excluirPosicoes(int id);
}
