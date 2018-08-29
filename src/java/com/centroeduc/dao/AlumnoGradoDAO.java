package com.centroeduc.dao;

import com.centroeduc.model.AlumnoGrado;
import com.centroeduc.model.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlumnoGradoDAO extends Conexion {

    private String sql;
    private PreparedStatement ejecutar;
    private String respuesta;
    ResultSet valores;

    AlumnoGrado asignacion = new AlumnoGrado();

    public String asignarAG(int year) {
        respuesta = null;
        try {
            this.Conectar();
            sql = "insert into alumnogrado (ciclo) value(?)";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setInt(1, year);
            ejecutar.executeUpdate();

            respuesta = "asignacion realizada";
           
        } catch (SQLException e) {
            System.out.println("error al asignar datos" + e);
        } finally {
            this.cerrarConex();
        }
        return respuesta;
    }
    public ArrayList<AlumnoGrado> MostrarDatosAlumnosGrado() {
        ArrayList<AlumnoGrado> lista = new ArrayList();
        try {
            this.Conectar();
            sql = "select* from alumnogrado";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            valores = this.ejecutar.executeQuery();
            while (valores.next()) {
                AlumnoGrado algr = new AlumnoGrado();
                algr.setCodAlumnoGrado(valores.getInt("cod_alumn_grad"));
                algr.setCodAlumnos(valores.getInt("cod_alumn"));
                algr.setCcursgradsecprof(valores.getInt("cod_curs_grad_sec_prof"));
                algr.setYear(valores.getInt("ciclo"));

                lista.add(algr);

            }
        } catch (SQLException e) {
            System.out.println("error en mostrar datos Alumnos Grado" + e);
        } finally {
            this.cerrarConex();
        }
        return lista;
    }

    public AlumnoGrado busquedaCodigo(int Codigo) {
        AlumnoGrado algra = new AlumnoGrado();
        try {
            this.Conectar();
            sql = "select* from alumnogrado where cod_alumn_grad=?";
            ejecutar = this.getMiconexion().prepareStatement(sql);
            ejecutar.setInt(1, Codigo);
            valores = ejecutar.executeQuery();
            if (valores.next()) {
                algra.setCodAlumnoGrado(valores.getInt("cod_alumn_grad"));
                algra.setCodAlumnos(valores.getInt("cod_alumn"));
                algra.setCcursgradsecprof(valores.getInt("cod_curs_grad_sec_prof"));
                algra.setYear(valores.getInt("ciclo"));
                
                ejecutar.close();
                valores.close();
            }
            
        } catch (SQLException ex) {
            System.out.println("error en buscar Codigo de alumno grado" + ex);
        } finally {
            this.cerrarConex();
        }
        return algra;
    }
    
}
