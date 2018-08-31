package com.centroeduc.controller;

import com.centroeduc.dao.AdminDAO;
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


    Secretaria secre = new Secretaria();
    SecreDao secretariaDao = new SecreDao();
    AdminDAO adminDao = new AdminDAO();

    public ArrayList<Secretaria> getListaSecre() {
        return listaSecre;
    }


    public AdminDAO getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDAO adminDao) {
        this.adminDao = adminDao;
    }
    

    public void setListaSecre(ArrayList<Secretaria> listaSecre) {
        this.listaSecre = listaSecre;
    }

    public void cargarSecre() {
     
        listaSecre = secretariaDao.MostrarSecretaria();
       
    }

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
            System.out.println("CONTROLADOR: ");
            System.out.println(secre.toString());
            secretariaDao.nuevaSecretaria(secre, admin);
            System.out.println("LLEGO AL CONTROLADOR CLIENTE");

        } catch (Exception e) {
            System.out.println("Error EN CONTROLADORSECRE:" + e);
        }
    }

    public void buscarSecre(Secretaria secre) {

        try {
            this.secre = secretariaDao.buscarCodigo(secre.getCodigo());
        } catch (Exception e) {
            System.out.println("Error en Busqueda, ControllerSecre" + e);
        }
    }

    public void editarSecre() {

        try {
            secretariaDao.editarSecretaria(secre);
        } catch (Exception e) {
            System.out.println("Error en Actualizar, ControladoCliente" + e);
        }
    } 
    
    public void estado(){
        try{
            secretariaDao.estado(secre);
        }catch(Exception e){
            System.out.println("Errr en Cambio de Estado,Controlador Estado");
        }
        
        
    }
}
