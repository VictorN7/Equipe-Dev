package com.senai.sp.projetotaiff.modal;

public class ZeroPeca {

    private int id_zeropeca;
    private float zp_posiX;
    private float zp_posiY;
    private float zp_posiZ;
    private float zp_posiR;


    public ZeroPeca() {
    }

    public ZeroPeca(int id_zeropeca, float zp_posiX, float zp_posiY, float zp_posiZ, float zp_posiR) {
        this.id_zeropeca = id_zeropeca;
        this.zp_posiX = zp_posiX;
        this.zp_posiY = zp_posiY;
        this.zp_posiZ = zp_posiZ;
        this.zp_posiR = zp_posiR;
    }

    public int getId_zeropeca() {
        return id_zeropeca;
    }

    public void setId_zeropeca(int id_zeropeca) {
        this.id_zeropeca = id_zeropeca;
    }

    public float getZp_posiX() {
        return zp_posiX;
    }

    public void setZp_posiX(float zp_posiX) {
        this.zp_posiX = zp_posiX;
    }

    public float getZp_posiY() {
        return zp_posiY;
    }

    public void setZp_posiY(float zp_posiY) {
        this.zp_posiY = zp_posiY;
    }

    public float getZp_posiZ() {
        return zp_posiZ;
    }

    public void setZp_posiZ(float zp_posiZ) {
        this.zp_posiZ = zp_posiZ;
    }

    public float getZp_posiR() {
        return zp_posiR;
    }

    public void setZp_posiR(float zp_posiR) {
        this.zp_posiR = zp_posiR;
    }
}
