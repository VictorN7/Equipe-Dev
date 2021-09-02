package com.senai.sp.projetoTaiff.Interface;

import com.senai.sp.projetoTaiff.Modal.Teste;

import java.util.List;

public interface Interface_Teste {

    Teste inserirTeste(Teste teste);
    List<Teste> listaTodosTestes() ;
    Teste buscarTesteId(int id);
    Teste alterarTeste(Teste teste, int id);
    int excluirTeste(int id);

}
