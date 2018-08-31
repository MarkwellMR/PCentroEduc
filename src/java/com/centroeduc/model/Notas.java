package com.centroeduc.model;

public class Notas {
    private int codNota;
    private int nota;
    
    public Notas(){
        
    }
    
    public Notas(int codNota, int nota){
    this.codNota= codNota;
    this.nota=nota;
    }

    public int getCodNota() {
        return codNota;
    }

    public void setCodNota(int codNota) {
        this.codNota = codNota;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
}
