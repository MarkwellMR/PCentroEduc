package com.centroeduc.controller;

import com.centroeduc.dao.AlumnoDAO;
import com.centroeduc.dao.GradoDAO;
import com.centroeduc.dao.SeccionDAO;
import com.centroeduc.model.Alumno;
import com.centroeduc.model.AsignacionGSCP;
import com.centroeduc.model.Grado;
import com.centroeduc.model.Seccion;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ControllerAlumno {

    ArrayList<Alumno> listaAlumno = new ArrayList();
    ArrayList<Grado> listaGrado = new ArrayList();
    ArrayList<Seccion> listaSeccion = new ArrayList();

    Alumno alum = new Alumno();
    Seccion sec = new Seccion();
    Grado grado = new Grado();
    AsignacionGSCP asigna = new AsignacionGSCP();

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AsignacionGSCP getAsigna() {
        return asigna;
    }

    public void setAsigna(AsignacionGSCP asigna) {
        this.asigna = asigna;
    }

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

    public ArrayList<Grado> getListaGrado() {
        return listaGrado;
    }

    public void setListaGrado(ArrayList<Grado> listaGrado) {
        this.listaGrado = listaGrado;
    }

    public ArrayList<Seccion> getListaSeccion() {
        return listaSeccion;
    }

    public void setListaSeccion(ArrayList<Seccion> listaSeccion) {
        this.listaSeccion = listaSeccion;
    }

    public Seccion getSec() {
        return sec;
    }

    public void setSec(Seccion sec) {
        this.sec = sec;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public void cargarAlumnos() {
        AlumnoDAO alumnodao = new AlumnoDAO();
        GradoDAO gradao = new GradoDAO();
        SeccionDAO secdao = new SeccionDAO();
        listaAlumno = alumnodao.mostrarAlumno();
        listaGrado = gradao.mostrarGrado();
        listaSeccion = secdao.MostrarSeccion();
    }

    public void guardarAlumno() {
        AlumnoDAO alumnodao = new AlumnoDAO();
        try {
            Alumno alumno = new Alumno();
            AsignacionGSCP asign = new AsignacionGSCP();
            alumnodao.ingresarAlum(alum, date);
            alumno = alumnodao.searchAlumno(alum);
            alum = alumno;
            asign = alumnodao.searchAsignacion(grado, sec);
            asigna = asign;
            //int obtenerCodigo = alumnodao.buscarDatos();
            //int buscar codGraSecProf = grasecprof.buscarcodigo();
        } catch (Exception e) {
            System.out.println("Error en el controlador de guardar alumno" + e);
        }
    }

    public void busquedaDatosAlumno(Alumno dato) {
        AlumnoDAO alumnodao = new AlumnoDAO();
        try {
            alum = alumnodao.busquedaDatos(dato.getCodAlumno());
        } catch (Exception e) {
            System.out.println("Error en el controlador de busqueda de datos " + e);
        }
    }

    public void busquedaCodigo() {
        AlumnoDAO alum1 = new AlumnoDAO();
        try {
            Alumno provisional = new Alumno();
            provisional = alum1.busquedaDatos(alum.getCodAlumno());
            alum = provisional;
            System.out.println("alumno: " + alum.getNombre());
        } catch (Exception ex) {
            System.out.println("Error controlador: " + ex);
        }
    }

    public void actualizarDatosAlumno() {
        AlumnoDAO alumdao = new AlumnoDAO();
        try {
            alumdao.modificarAlumno(alum, date);
        } catch (Exception e) {
            System.out.println("Error controlador actualizar Alumno" + e);
        }
    }

    public void cambioEstado() {
        AlumnoDAO alumn = new AlumnoDAO();
        try {
            alumn.estadoAlumno(alum);
        } catch (Exception e) {
            System.out.println("error en el controlador de cambio de estado" + e);
        }
    }

    public void saveAsign() {
        AlumnoDAO dao = new AlumnoDAO();
        try {
            dao.nuevaAsign(alum, asigna);
        } catch (Exception e) {
            System.out.println("Error en saveAsign: " + e);
        }
    }
}
