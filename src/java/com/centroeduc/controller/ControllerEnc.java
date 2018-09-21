package com.centroeduc.controller;

import com.centroeduc.dao.EncargadoDAO;
import com.centroeduc.model.Encargado;
import com.centroeduc.model.Secretaria;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ControllerEnc implements Serializable{
    
    public String valorABuscar;
    Encargado enc = new Encargado();
    Secretaria sec = new Secretaria();
    EncargadoDAO encdao = new EncargadoDAO();
    ArrayList<Encargado> listaEnc = new ArrayList();
    ArrayList<Encargado> listaBusEnc = new ArrayList();

    public ArrayList<Encargado> getListaBusEnc() {
        return listaBusEnc;
    }

    public void setListaBusEnc(ArrayList<Encargado> listaBusEnc) {
        this.listaBusEnc = listaBusEnc;
    }

    public ArrayList<Encargado> getListaEnc() {
        return listaEnc;
    }

    public void setListaEnc(ArrayList<Encargado> listaEnc) {
        this.listaEnc = listaEnc;
    }
    
    public void cargarDatos(){
        listaEnc = encdao.MostarEncargado();
        
    }
    public void loadDatos(){
        listaBusEnc = encdao.BusquedaXnombre(enc.getNombre());
    }
    
    public void buscarPorNombre(){
        listaBusEnc= encdao.BusquedaXnombre(enc.getNombre());
        System.out.println("CONTROLADOR ENCARGADO");
        for (Encargado encargado : listaEnc) {
            System.out.println("nombre: " + encargado.getNombre());
        }
    }
    

    public Encargado getEnc() {
        return enc;
    }

    public void setEnc(Encargado enc) {
        this.enc = enc;
    }

    public Secretaria getSec() {
        return sec;
    }

    public void setSec(Secretaria sec) {
        this.sec = sec;
    }
    
    public void guardarEnc(){
        try {
            encdao.nuevoEncargado(enc, sec);
                    
        } catch (Exception e) {
            System.out.println("Error en Guardar " + e);
        }
    }
    
    public void searchEnc(Encargado datos ){
        try {
            System.out.println("LLEGO");
            
            Encargado provicional = new Encargado();
            System.out.println("CONTROLADOR: CODIGO " + datos.getCodEnc());
            provicional = encdao.searchId(datos.getCodEnc());
            
            this.enc = provicional;
            
        } catch (Exception e) {
            System.out.println("error en el metdo SearcEnc " + e);
        }
    }
    
    public void updEnc(){
        try {
            encdao.UpEnc(enc);
        } catch (Exception e) {
            System.out.println("Error en Actualizar "+e );
        }
    }
    
    public void deleteEnc(){
        try {
            encdao.cambioEstado(enc.getCodEnc());
        } catch (Exception e) {
            
        }
    }
    
    
}
