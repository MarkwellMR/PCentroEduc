package com.centroeduc.dao;

import com.centroeduc.model.Conexion;
import com.centroeduc.model.Notas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NotasDAO extends Conexion {

    Notas notas = new Notas();
    ArrayList<Notas> listaNotas = null;

    private String sql;
    private PreparedStatement run;
    private String answer;
    ResultSet resultado;

    public String agregarNotas(Notas nota) {
        answer = null;
        try {
            this.Conectar();
            sql = "insert into nota(cod_alumn_grad,nota,cod_unidad) values(?,?,?)";
            run = this.getMiconexion().prepareStatement(sql);
            run.setInt(1, nota.getCodAlumGrado());
            run.setInt(2, nota.getNota());
            run.setInt(3, nota.getCodUnidad());

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

    public String modificar(Notas nota) {
        answer = null;
        try {
            this.Conectar();
            sql = "update nota set nota=? where cod_nota= ?";
            run = this.getMiconexion().prepareStatement(sql);
            run.setInt(1, nota.getNota());
            run.setInt(2, nota.getCodNota());

            run.executeUpdate();
            System.out.println("Nota Actualizada Correctamente ");
            answer = "Nota Actualizada Correctamente ";
            run.close();
        } catch (SQLException e) {
            answer = "Error en Actualizar notas " + e;
            System.out.println("Error en Actualizar notas " + e);
        } finally {
            this.cerrarConex();
        }
        return answer;
    }

    public ArrayList<Notas> MostrarNotas() {
        try {
            this.Conectar();
            sql = "select * from nota";
            run = this.getMiconexion().prepareStatement(sql);
            resultado = run.executeQuery();
            listaNotas = new ArrayList();
            while (resultado.next()) {
                Notas nota = new Notas();
                nota.setCodNota(resultado.getInt("cod_nota"));
                nota.setNota(resultado.getInt("nota"));
                nota.setCodUnidad(resultado.getInt("cod_unidad"));
                nota.setCodAlumGrado(resultado.getInt("cod_alumn_grad"));
                listaNotas.add(nota);
            }
        resultado.close();
        
        } catch (SQLException e) {
            System.out.println("Error " + e );
        }finally{
            this.cerrarConex();
        }

        return listaNotas;
    }
}
