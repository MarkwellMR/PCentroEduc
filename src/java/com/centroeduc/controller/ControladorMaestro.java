package com.centroeduc.controller;

import com.centroeduc.dao.MaestroDAO;
import com.centroeduc.model.Maestro;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped

public class ControladorMaestro {

    ArrayList<Maestro> mostrarMaestro = new ArrayList();
    Maestro maes = new Maestro();
    
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Maestro getMaes() {
        return maes;
    }

    public void setMaes(Maestro maes) {
        this.maes = maes;
    }

    public ArrayList<Maestro> getMostrarMaestro() {
        return mostrarMaestro;
    }

    public void setMostrarMaestro(ArrayList<Maestro> mostrarMaestro) {
        this.mostrarMaestro = mostrarMaestro;
    }

    public void cargarMaestro() {
        MaestroDAO daou = new MaestroDAO();
        mostrarMaestro = daou.Mostrarprofesor();
    }

    public void guardarMaestro() {
        MaestroDAO daou = new MaestroDAO();
        try {
            daou.insertarMaestro(maes, date);
        } catch (Exception e) {
            System.out.println("error en controlador maestro" + e);
        }
    }

    public void busquedaDatosMaestro(Maestro dato) {
        MaestroDAO daoum = new MaestroDAO();
        try {
            maes = daoum.buscarCodigo(dato.getCodigo());
        } catch (Exception e) {
            System.out.println("Error en el controlador de busqueda de datos " + e);
        }
    }

    public void actualizarMaestro() {
        MaestroDAO dao = new MaestroDAO();
        try {
            dao.editarMaestro(maes, date);
        } catch (Exception e) {
            System.out.println("Error en el controlador de actualizar Mestro" + e);
        }
    }

    public void busquedaCodigo() {
        MaestroDAO daoum = new MaestroDAO();
        try {
            Maestro ma = new Maestro();
            ma = daoum.buscarCodigo(maes.getCodigo());
            maes = ma;
            System.out.println("Maestro: " + maes.getNombre());
        } catch (Exception ex) {
            System.out.println("Error controlador: " + ex);
        }
    }

    public void elEstado() {
        MaestroDAO maest = new MaestroDAO();
        try {
            maest.estadoMaestro(maes);
        } catch (Exception e) {
            System.out.println("error en controlador estado" + e);
        }
    }

}
