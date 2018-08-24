package com.centroeduc.controller;

import com.centroeduc.dao.CursoDAO;
import com.centroeduc.dao.GradoDAO;
import com.centroeduc.dao.MaestroDAO;
import com.centroeduc.dao.SeccionDAO;
import com.centroeduc.model.Curso;
import com.centroeduc.model.Grado;
import com.centroeduc.model.Maestro;
import com.centroeduc.model.Seccion;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean
@ViewScoped

public class ControllerAsigCurso {
    // Instancia DAOs
    CursoDAO cursodao = new CursoDAO();
    GradoDAO gradodao = new GradoDAO();
    SeccionDAO secdao = new SeccionDAO();
    MaestroDAO maesdao = new MaestroDAO();
    //Instancia Clases 
    Curso curso = new Curso();
    Grado grado = new Grado();
    Seccion seccion = new Seccion();
    Maestro maestro = new Maestro();
    //Array List the objetos
    ArrayList<Grado> ListaGrado = new ArrayList();
    ArrayList<Curso> ListaCurso = new ArrayList();
    ArrayList<Seccion> ListaSeccion = new ArrayList();
    ArrayList<Maestro> ListaMaestros = new ArrayList();

    List<String> nombreCurso;
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    public ArrayList<Grado> getListaGrado() {
        return ListaGrado;
    }

    public void setListaGrado(ArrayList<Grado> ListaGrado) {
        this.ListaGrado = ListaGrado;
    }

    public ArrayList<Curso> getListaCurso() {
        return ListaCurso;
    }

    public void setListaCurso(ArrayList<Curso> ListaCurso) {
        this.ListaCurso = ListaCurso;
    }

    public ArrayList<Seccion> getListaSeccion() {
        return ListaSeccion;
    }

    public void setListaSeccion(ArrayList<Seccion> ListaSeccion) {
        this.ListaSeccion = ListaSeccion;
    }

    public ArrayList<Maestro> getListaMaestros() {
        return ListaMaestros;
    }

    public void setListaMaestros(ArrayList<Maestro> ListaMaestros) {
        this.ListaMaestros = ListaMaestros;
    }
    
    
    
    public void cargarListas(){
        this.ListaMaestros = this.maesdao.Mostrarprofesor();
        this.ListaCurso = this.cursodao.listCourse();
        this.ListaGrado = this.gradodao.mostrarGrado();
        this.ListaSeccion = this.secdao.MostrarSeccion();
        
    
    }
    
    public void asignarCurso(){
        System.out.println("Curso: " + this.curso.getCod());
        System.out.println("Grado: " + this.grado.getCod_grado());
        System.out.println("Sección: " + this.seccion.getCodigo());
        System.out.println("Maestro: " + this.maestro.getCodigo());
        
    }
    
    
    
}
