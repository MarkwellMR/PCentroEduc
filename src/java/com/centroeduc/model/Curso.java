
package com.centroeduc.model;

public class Curso {
    private Integer cod;
    private String nombre;
    private String hInicio;
    private String hFin;
    private String jornada;
    private Integer cupo;

    public Curso() {
        this.cod = null;
        this.nombre = null;
        this.hInicio = null;
        this.hFin = null;
        this.jornada = null;
        this.cupo = null;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String gethInicio() {
        return hInicio;
    }

    public void sethInicio(String hInicio) {
        this.hInicio = hInicio;
    }

    public String gethFin() {
        return hFin;
    }

    public void sethFin(String hFin) {
        this.hFin = hFin;
    }
    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public Integer getCupo() {
        return cupo;
    }

    public void setCupo(Integer cupo) {
        this.cupo = cupo;
    }
    
    
    
    
}
