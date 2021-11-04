package com.senai.sp.projetotaiff.interfaces;

import com.senai.sp.projetotaiff.modal.Posicoes;

import java.util.List;

public interface Interface_Posicoes {

    Posicoes inserirPosicoes(Posicoes posicoes);
    List<Posicoes> listarTodasPosicoes();
    Posicoes buscarPosicoesId(int id);
    int alterarPosicoes(int id, Posicoes posicoes);
    boolean excluirPosicoes(int id);
}
