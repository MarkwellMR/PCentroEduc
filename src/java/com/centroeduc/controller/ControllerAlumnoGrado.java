/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroeduc.controller;

import com.centroeduc.dao.AlumnoDAO;
import com.centroeduc.dao.AlumnoGradoDAO;
import com.centroeduc.dao.AsignGSCPDAO;
import com.centroeduc.model.Alumno;
import com.centroeduc.model.AlumnoGrado;
import com.centroeduc.model.AsignacionGSCP;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped



/**
 *
 * @author Usuario
 */
public class ControllerAlumnoGrado {
    AlumnoGradoDAO alumgrad= new AlumnoGradoDAO();
    AlumnoDAO alum = new AlumnoDAO();
    AsignGSCPDAO dao = new AsignGSCPDAO();
    
    Alumno alumno = new Alumno ();
    AsignacionGSCP asing = new AsignacionGSCP();
    
    //ArrayList<AsignacionGSCP> ListaGSCP = new ArrayList();
    ArrayList<Alumno> ListaAlumno = new ArrayList();
    ArrayList<AlumnoGrado> ListaAlumnoGrado = new ArrayList();
    AlumnoGrado datos = new AlumnoGrado();

    public AlumnoGrado getDatos() {
        return datos;
    }

    public void setDatos(AlumnoGrado datos) {
        this.datos = datos;
    }
    
    
    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public AsignacionGSCP getAsing() {
        return asing;
    }

    public void setAsing(AsignacionGSCP asing) {
        this.asing = asing;
    }
     public ArrayList<AlumnoGrado> getListaAlumnoGrado() {
        return ListaAlumnoGrado;
    }

    public void setListaAlumnoGrado(ArrayList<AlumnoGrado> listaGradoAlum) {
        this.ListaAlumnoGrado = listaGradoAlum;
    }
    public void cargarListasAlumnosGrado(){
        AlumnoGradoDAO graddao=new AlumnoGradoDAO();
        ListaAlumnoGrado=graddao.MostrarDatosAlumnosGrado();
    }
    public void guardarAlumnoGrado(){
        AlumnoGradoDAO graddao=new AlumnoGradoDAO();
        try{
            graddao.asignarAG(datos.CodAlumnoGrado);
        }catch (Exception e){
            System.out.println("Error en el controlador de guardar grado Alumno"+ e);
        }
    }
      
     public void busquedaDatosAlumnoGrado(AlumnoGrado dato) {
       AlumnoGradoDAO daoum = new AlumnoGradoDAO();
        try {
            datos = daoum.busquedaCodigo(dato.getCodAlumnoGrado());
        } catch (Exception e) {
            System.out.println("Error en el controlador de busqueda de datos " + e);
        }
    }
  public void busquedaCodigoAlumnoGrado() {
        AlumnoGradoDAO daoum = new AlumnoGradoDAO();
        try {
            AlumnoGrado ma = new AlumnoGrado();
            ma = daoum.busquedaCodigo(datos.getCodAlumnoGrado());
            datos = ma;
            
        } catch (Exception ex) {
            System.out.println("Error controlador de busqueda codigo alumno: " + ex);
        }
    }
     
    
            
   
    
    
    
}
