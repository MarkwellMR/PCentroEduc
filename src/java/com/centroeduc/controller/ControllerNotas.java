package com.centroeduc.controller;

import com.centroeduc.dao.NotasDAO;
import com.centroeduc.model.Grado;
import com.centroeduc.model.Notas;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ControllerNotas {
    Notas nota = new Notas();
    Grado grado = new Grado();
    ArrayList<Notas> listaNotas = new ArrayList();
    ArrayList<Grado> listaGrado = new ArrayList();

    public ArrayList<Notas> getListaNotas() {
        return listaNotas;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public void setListaNotas(ArrayList<Notas> listaNotas) {
        this.listaNotas = listaNotas;
    }

    public ArrayList<Grado> getListaGrado() {
        return listaGrado;
    }

    NotasDAO notasdao = new NotasDAO();
    public Notas getNota() {
        return nota;
    }

    public void setNota(Notas nota) {
        this.nota = nota;
    }
    
    public void mostrarNotas(){
        try {
            listaNotas = notasdao.MostrarNotas();
        } catch (Exception e) {
            System.out.println("Erro en Metodo Mostrar Notas " + e);
        }
    }
    public void agregarNotas(){
        try {
            notasdao.agregarNotas(nota);
        } catch (Exception e) {
            System.out.println("Error en El Metodo AgregarNotas: " + e);
        }
    }
    
    public ArrayList<Grado> ListasGrado(String maestro){
        try {
            listaGrado = notasdao.MostrarGrado(maestro);
        } catch (Exception e) {
            System.out.println("Error en ListasGrado: " + e);
        }
        return listaGrado;
    }
}
