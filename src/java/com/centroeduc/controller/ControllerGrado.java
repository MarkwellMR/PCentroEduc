
package com.centroeduc.controller;


import com.centroeduc.dao.GradoDAO;
import com.centroeduc.model.Grado;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



@ManagedBean
@ViewScoped
public class ControllerGrado {
    ArrayList<Grado> listaGrado= new ArrayList();
    Grado grado =new Grado();
     public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public ArrayList<Grado> getListaGrado() {
        return listaGrado;
    }

    public void setListaGrado(ArrayList<Grado> listaGrado) {
        this.listaGrado = listaGrado;
    }
    public void cargarGrado(){
        GradoDAO graddao=new GradoDAO();
        listaGrado=graddao.mostrarGrado();
    }
    public void guardarGrado(){
        GradoDAO graddao=new GradoDAO();
        try{
            graddao.ingresarGrado(grado);
        }catch (Exception e){
            System.out.println("Error en el controlador de guardar grado"+ e);
        }
    }
    public void busquedaDatosGrado(Grado dato){
        GradoDAO graddao=new GradoDAO();
        try{
           grado =graddao.busquedaDatos(dato.getCod_grado());
        }catch(Exception e){
            System.out.println("Error en el controlador de busqueda de datos "+e);
        }
    }
    public void busquedaCodigo(){
        GradoDAO grad1=new GradoDAO();
        try{
            Grado provisional = new Grado();
            provisional = grad1.busquedaDatos(grado.getCod_grado());
           grado = provisional;
            System.out.println("alumno: " + grado.getDescripcion());
        }catch(Exception ex ){
            System.out.println("Error controlador busqueda Codigo: " + ex);
        }
    }
    public void actualizarDatosGrado(){
        GradoDAO gradodao= new GradoDAO();
        try{
        gradodao.modificarGrado(grado);
       }catch(Exception e){
            System.out.println("Error controlador actualizar Grado"+e);
       }
    }
    public void elimGrado(){
        GradoDAO grados= new GradoDAO();
        try{
            grados.eliminarGrado(grado.getCod_grado());
        }catch (Exception e){
            System.out.println("error en el controlador de cambio de estado"+e);
        }
    }
}
