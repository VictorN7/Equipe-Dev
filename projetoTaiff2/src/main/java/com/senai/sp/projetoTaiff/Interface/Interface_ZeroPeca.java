package com.senai.sp.projetoTaiff.Interface;

import com.senai.sp.projetoTaiff.Modal.ZeroPeca;

import java.util.List;

public interface Interface_ZeroPeca {

    int inserirZeroPeca(ZeroPeca zeroPeca);
    List<ZeroPeca> listarTodosZeroPeca();
    ZeroPeca buscarZeroPecaId(int id);
    int alterarZeroPeca(int id, ZeroPeca zp);
    int excluirZeroPeca(int id);
}
