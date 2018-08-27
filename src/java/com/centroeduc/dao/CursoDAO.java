package com.centroeduc.dao;

import com.centroeduc.model.Conexion;
import com.centroeduc.model.Curso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursoDAO extends Conexion {

    private String sql;
    private PreparedStatement run;
    private String answer;
    ResultSet values;

    Curso curso = new Curso();

    //almacenar
    public String newCurso(Curso course) {
        answer = null;
        try {
            this.Conectar();
            sql = "insert into curso(nombre, hinicio, hfin, jornada, cupo) values(?,?,?,?,?)";
            run = this.getMiconexion().prepareStatement(sql);
            run.setString(1, course.getNombre());
            run.setString(2, course.gethInicio());
            run.setString(3, course.gethFin());
            run.setString(4, course.getJornada());
            run.setInt(5, course.getCupo());

            run.executeUpdate();

            answer = "Curso Almacenado";

            run.close();
            values.close();
        } catch (SQLException e) {
            System.out.println("Error CursoDAO(almacenar): " + e);
            answer = "No se pudo Almacenar el Curso";
        } finally {
            this.cerrarConex();
        }
        return answer;
    }

    //Buscar
    public ArrayList<Curso> listCourse() {
        ArrayList<Curso> list = null;
        values = null;
        try {
            this.Conectar();
            sql = "select * from curso";
            run = this.getMiconexion().prepareStatement(sql);
            values = run.executeQuery();
            list = new ArrayList();

            while (values.next()) {
                Curso course = new Curso();
                course.setCod(this.values.getInt("cod_curso"));
                course.setNombre(this.values.getString("nombre"));
                course.sethInicio(this.values.getString("hinicio"));
                course.sethFin(this.values.getString("hfin"));
                course.setJornada(this.values.getString("jornada"));
                course.setCupo(this.values.getInt("cupo"));
                list.add(course);
            }

            values.close();
            run.close();
        } catch (SQLException e) {
            System.out.println("Error en CursoDAO(Lista): " + e);
        } finally {
            this.cerrarConex();
        }
        return list;
    }

    public String updateCourse(Curso course) {
        answer = null;
        try {
            this.Conectar();
            sql = "update curso set nombre=?, hinicio=?, hfin=?, jornada=?, cupo=? where cod_curso=?";
            run = this.getMiconexion().prepareStatement(sql);
            run.setString(1, course.getNombre());
            run.setString(2, course.gethInicio());
            run.setString(3, course.gethFin());
            run.setString(3, course.getJornada());
            run.setInt(4, course.getCupo());
            run.setInt(5, course.getCod());

            run.executeUpdate();
            answer = "Curso actualizado";

            run.close();
        } catch (SQLException e) {
            System.out.println("Error en CursoDAO(update): " + e);
            answer = "No se pudo modificar";
        } finally {
            this.cerrarConex();
        }
        return answer;
    }

    //eliminar
    public String deleteCourse(int codigo) {
        answer = null;
        try {
            this.Conectar();
            sql = "delete from curso where cod_curso=?";
            run = this.getMiconexion().prepareStatement(sql);
            run.setInt(1, codigo);
            run.executeUpdate();
            answer = "Eliminado con Exito";

            run.close();
        } catch (SQLException e) {
            System.out.println("Error CursoDAO(Eliminar): " + e);
            answer = "No se pudo eliminar";
        }
        return answer;
    }

    public Curso serachId(int codigo) {
        Curso course = new Curso();
        try {
            this.Conectar();
            sql = "select * from curso where cod_curso=?";
            run = this.getMiconexion().prepareStatement(sql);
            run.setInt(1, codigo);
            this.values = this.run.executeQuery();
            if (this.values.next()) {
                course.setCod(this.values.getInt("cod_curso"));
                course.setNombre(this.values.getString("nombre"));
                course.sethInicio(this.values.getString("hinicio"));
                course.sethFin(this.values.getString("hfin"));
                course.setJornada(this.values.getString("jornada"));
                course.setCupo(this.values.getInt("cupo"));
            }else{
                System.out.println("No se encotraron coincidencias");
            }
            this.values.close();
            this.run.close();
        } catch (SQLException e) {
            System.out.println("Error en CursoDAO(serchId): " + e);
        }finally{
            this.cerrarConex();
        }
        return course;
    }
}
