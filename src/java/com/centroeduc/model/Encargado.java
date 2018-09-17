package com.centroeduc.model;

public class Encargado extends Persona {
    private Integer codEnc;

    public Encargado() {
        this.codEnc=null;
    }

    public Encargado(Integer codEnc) {
        this.codEnc = codEnc;
    }

    public Integer getCodEnc() {
        return codEnc;
    }

    public void setCodEnc(Integer codEnc) {
        this.codEnc = codEnc;
    }
}
