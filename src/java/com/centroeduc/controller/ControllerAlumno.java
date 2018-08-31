
package com.centroeduc.controller;

import com.centroeduc.dao.AlumnoDAO;
import com.centroeduc.model.Alumno;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



@ManagedBean
@ViewScoped
public class ControllerAlumno {
    ArrayList<Alumno> listaAlumno= new ArrayList();
    
    Alumno alum=new Alumno();
    
     public Alumno getAlum() {
        return alum;
    }

    public void setAlum(Alumno alum) {
        this.alum = alum;
    }

    public ArrayList<Alumno> getListaAlumno() {
        return listaAlumno;
    }

    public void setListaAlumno(ArrayList<Alumno> listaAlumno) {
        this.listaAlumno = listaAlumno;
    }
    public void cargarAlumnos(){
        AlumnoDAO alumnodao=new AlumnoDAO();
        listaAlumno=alumnodao.mostrarAlumno();
    }
    public void guardarAlumno(){
        AlumnoDAO alumnodao=new AlumnoDAO();
        try{
            alumnodao.ingresarAlum(alum);
        }catch (Exception e){
            System.out.println("Error en el controlador de guardar alumno"+ e);
        }
    }
    public void busquedaDatosAlumno(Alumno dato){
        AlumnoDAO alumnodao=new AlumnoDAO();
        try{
            alum =alumnodao.busquedaDatos(dato.getCodAlumno());
        }catch(Exception e){
            System.out.println("Error en el controlador de busqueda de datos "+e);
        }
    }
    public void busquedaCodigo(){
        AlumnoDAO alum1=new AlumnoDAO();
        try{
            Alumno provisional = new Alumno();
            provisional = alum1.busquedaDatos(alum.getCodAlumno());
            alum = provisional;
            System.out.println("alumno: " + alum.getNombre());
        }catch(Exception ex ){
            System.out.println("Error controlador: " + ex);
        }
    }
    public void actualizarDatosAlumno(){
        AlumnoDAO alumdao= new AlumnoDAO();
        try{
        alumdao.modificarAlumno(alum);
       }catch(Exception e){
            System.out.println("Error controlador actualizar Alumno"+e);
       }
    }
    public void cambioEstado(){
        AlumnoDAO alumn= new AlumnoDAO();
        try{
            alumn.estadoAlumno(alum);
        }catch (Exception e){
            System.out.println("error en el controlador de cambio de estado"+e);
        }
    }
}
