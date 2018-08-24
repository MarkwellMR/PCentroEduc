
package com.centroeduc.controller;

import com.centroeduc.dao.SecreDao;
import com.centroeduc.model.Administrador;
import com.centroeduc.model.Secretaria;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.ToggleEvent;

@ManagedBean
@ViewScoped

public class ControllerSecre {

    ArrayList<Secretaria> listaSecre = new ArrayList();

    
    public ArrayList<Secretaria> getListaSecre() {
        return listaSecre;
    }

    public void setListaSecre(ArrayList<Secretaria> listaSecre) {
        this.listaSecre = listaSecre;
    }

    public void cargarSecre() {
        SecreDao secretariaDao = new SecreDao();
        listaSecre = secretariaDao.MostrarSecretaria();
    }

    Secretaria secre = new Secretaria();

    public Secretaria getSecre() {
        return secre;
    }

    public void setSecretaria(Secretaria secre) {
        this.secre = secre;
    }

         /*INGRESO CLIENTE*/
    public void guardarSecre() {
        SecreDao secretariaDao = new SecreDao();
        Administrador admin = new Administrador();
        admin.setCodigo("A0001");
        try {
            secretariaDao.nuevaSecretaria(secre, admin);
            System.out.println("LLEGO AL CONTROLADOR CLIENTE");

        } catch (Exception e) {
             System.out.println("Error EN CONTROLADORSECRE:" + e);
        }
    }
    
    public void buscarSecre(Secretaria secre){
        SecreDao secretariaDao = new SecreDao();
        try{
            this.secre= secretariaDao.buscarCodigo(Integer.parseInt(secre.getCodigo()));
        }catch(Exception e){
            System.out.println("Error en Busqueda, ControllerSecre" + e);
        }
    }
         
    public void editarSecre(){
        SecreDao secretariaDao = new SecreDao();
        
        try{
           secretariaDao.editarSecretaria(secre);
        }catch(Exception e){
            System.out.println("Error en Actualizar, ControladoCliente" + e);
        }                
    }
    
//    public void eliminarSecretaria(Secretaria secre){
//            SecreDao secretariaDao = new SecreDao();
//        try{
//            secretariaDao.eliminarSecretaria(this.secre.getCodigo());        
//        }catch(Exception e){
//            System.out.println("Error en Controlador Eliminar Cliente" + e);
//        
//        }
//    }
  
}
