package com.senai.sp.projetotaiff.modal;

import java.util.List;

public class Posicoes {
    private int id_posicao;
    private float posiX;
    private float posiY;
    private float posiZ;
    private float posiR;
    private int id_teste;
    private List<Temperatura> temperaturas;


    public Posicoes() {
    }

    public Posicoes(int id_posicao, float posiX, float posiY, float posiZ, float posiR, int id_teste, List<Temperatura> temperaturas) {
        this.id_posicao = id_posicao;
        this.posiX = posiX;
        this.posiY = posiY;
        this.posiZ = posiZ;
        this.posiR = posiR;
        this.id_teste = id_teste;
        this.temperaturas = temperaturas;
    }

    public int getId_posicao() {
        return id_posicao;
    }

    public void setId_posicao(int id_posicao) {
        this.id_posicao = id_posicao;
    }

    public float getPosiX() {
        return posiX;
    }

    public void setPosiX(float posiX) {
        this.posiX = posiX;
    }

    public float getPosiY() {
        return posiY;
    }

    public void setPosiY(float posiY) {
        this.posiY = posiY;
    }

    public float getPosiZ() {
        return posiZ;
    }

    public void setPosiZ(float posiZ) {
        this.posiZ = posiZ;
    }

    public float getPosiR() {
        return posiR;
    }

    public void setPosiR(float posiR) {
        this.posiR = posiR;
    }

    public int getId_teste() {
        return id_teste;
    }

    public void setId_teste(int id_teste) {
        this.id_teste = id_teste;
    }

    public List<Temperatura> getTemperaturas() {
        return temperaturas;
    }

    public void setTemperaturas(List<Temperatura> temperaturas) {
        this.temperaturas = temperaturas;
    }
}
