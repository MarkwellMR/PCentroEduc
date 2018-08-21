package com.centroeduc.controller;

import com.centroeduc.dao.EncargadoDAO;
import com.centroeduc.model.Encargado;
import com.centroeduc.model.Secretaria;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ControllerEnc {
    
    Encargado enc = new Encargado();
    Secretaria sec = new Secretaria();
    EncargadoDAO encdao = new EncargadoDAO();
    ArrayList<Encargado> listaEnc = new ArrayList();

    public ArrayList<Encargado> getListaEnc() {
        return listaEnc;
    }

    public void setListaEnc(ArrayList<Encargado> listaEnc) {
        this.listaEnc = listaEnc;
    }
    
    public void cargarDatos(){
        listaEnc = encdao.MostarEncargado();
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
            this.enc = encdao.searchId(datos.getCodigo());
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
            encdao.delEnc(enc.getCodigo());
        } catch (Exception e) {
            
        }
    }
    
    
}
