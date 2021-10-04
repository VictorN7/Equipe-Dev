package com.senai.sp.projetotaiff.modal;

import java.util.List;

public class Teste {
    private ZeroPeca zeropeca;
    private int id_teste;
    private String nome_modelo;
    private List<Posicoes> posicao;


    public Teste() {
    }

    public Teste(int id_teste, String nome_modelo, List<Posicoes> posicao, ZeroPeca zeropeca) {
        this.id_teste = id_teste;
        this.nome_modelo = nome_modelo;
        this.posicao = posicao;
        this.zeropeca = zeropeca;
    }

    public int getId_teste() {
        return id_teste;
    }

    public void setId_teste(int id_teste) {
        this.id_teste = id_teste;
    }

    public String getNome_modelo() {
        return nome_modelo;
    }

    public void setNome_modelo(String nome_modelo) {
        this.nome_modelo = nome_modelo;
    }

    public List<Posicoes> getPosicao() {
        return posicao;
    }

    public void setPosicao(List<Posicoes> posicao) {
        this.posicao = posicao;
    }

    public ZeroPeca getZeropeca() {
        return zeropeca;
    }

    public void setZeropeca(ZeroPeca zeropeca) {
        this.zeropeca = zeropeca;
    }
}
