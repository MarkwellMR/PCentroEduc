package com.centroeduc.controller;

import com.centroeduc.dao.SeccionDAO;
import com.centroeduc.model.Seccion;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped

public class ControladorSeccion {

    ArrayList<Seccion> mostrarSeccion = new ArrayList();
    Seccion sec = new Seccion();

    public Seccion getSec() {
        return sec;
    }

    public void setSec(Seccion sec) {
        this.sec = sec;
    }

    public ArrayList<Seccion> getMostrarSeccion() {
        return mostrarSeccion;
    }

    public void setMostrarSeccion(ArrayList<Seccion> mostrarSeccion) {
        this.mostrarSeccion = mostrarSeccion;
    }

    public void cargarSeccion() {
        SeccionDAO secda = new SeccionDAO();
        mostrarSeccion = secda.MostrarSeccion();
    }

    public void guardarSeccion() {
        SeccionDAO secd = new SeccionDAO();
        try {
            secd.insertarSeccion(sec);
        } catch (Exception e) {
            System.out.println("error en controlador maestro" + e);
        }
    }

    public void busquedaSeccion(Seccion secci) {
        SeccionDAO sed = new SeccionDAO();
        try {
            sec = sed.buscarCodigo(secci.getCodigo());
        } catch (Exception e) {
            System.out.println("error en el controlador de busqueda de datos" + e);
        }
    }

    public void actualizarSeccion() {
        SeccionDAO daos = new SeccionDAO();
        try {
            daos.editarSeccion(sec);
        } catch (Exception e) {
            System.out.println("error en controlador actualizar seccion" + e);
        }
    }

    public void busquedaCodigo() {
        SeccionDAO daose = new SeccionDAO();
        try {
            Seccion secci = new Seccion();
            secci = daose.buscarCodigo(sec.getCodigo());
            sec = secci;
            System.out.println("Seccion: " + sec.getDescripcion());
        } catch (Exception ex) {
            System.out.println("error en controlador busqueda" + ex);
        }
    }

    public void eliminarSeccion() {
        SeccionDAO secd = new SeccionDAO();
        try {
            secd.eliminarSeccion(sec.getCodigo());
        } catch (Exception e) {
            System.out.println("error en controlador eliminar" + e);
        }
    }

}
