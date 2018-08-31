package com.centroeduc.dao;

import com.centroeduc.model.AlumnoGrado;
import com.centroeduc.model.Conexion;
import com.centroeduc.model.Notas;
import com.centroeduc.model.Unidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NotasDAO extends Conexion {

    Notas notas = new Notas();
    Unidad unidad = new Unidad();
    AlumnoGrado alumGrad = new AlumnoGrado();

    private String sql;
    private PreparedStatement run;
    private String answer;
    ResultSet resultado;

    public String agregarNotas(Notas nota, Unidad unidad, AlumnoGrado alumGrad) {
        answer = null;
        try {
            this.Conectar();
            sql = "insert into nota(cod_alumn_grad,nota,cod_unidad) values(?,?,?)";
            run = this.getMiconexion().prepareStatement(sql);
            run.setInt(1, alumGrad.getCodAlumnoGrado());
            run.setInt(2, nota.getNota());
            run.setInt(3, unidad.getCodigo());

            run.executeUpdate();
            System.out.println("Dato Almacenado");
            answer = "Dato Almacenado Correctamente";
            run.close();
        } catch (SQLException e) {
            answer = "Error en el DAO: " + e;
            System.out.println("Error " + e);
        } finally {
            this.cerrarConex();
        }
        return answer;
    }
    
    public String modificar(AlumnoGrado alumGrad, Notas nota){
        answer = null; 
        try {
            this.Conectar();
            sql= "update nota set nota=? where  ";
        } catch (Exception e) {
        }
        return answer;
    }

}
