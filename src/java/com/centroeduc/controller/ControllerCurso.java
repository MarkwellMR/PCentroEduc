
package com.centroeduc.controller;

import com.centroeduc.dao.CursoDAO;
import com.centroeduc.model.Curso;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ControllerCurso {
    ArrayList<Curso> listCurso = new ArrayList();
    CursoDAO dao = new CursoDAO();
    Curso course = new Curso();

    public ArrayList<Curso> getListCurso() {
        return listCurso;
    }

    public void setListCurso(ArrayList<Curso> listCurso) {
        this.listCurso = listCurso;
    }
    
    public void loadCurso(){
        listCurso = dao.listCurso(course.getNombre());
    }

    public Curso getCourse() {
        return course;
    }

    public void setCourse(Curso course) {
        this.course = course;
    }
    
    public void saveCurso(){
        try {
            dao.newCurso(course);
        } catch (Exception e) {
            System.out.println("Error en ControllerCurso(save): " + e);
        }
    }
    
    public void updateCurso(){
        try {
            dao.updateCourse(course);
        } catch (Exception e) {
            System.out.println("Error en ControllerCurso(update): " + e);
        }
    }
    
    public void deleteCurso(){
        try {
            dao.deleteCourse(course.getCod());
        } catch (Exception e) {
            System.out.println("Error en ControllerCurso(delete): " + e);
        }
    }
    
    public void searchCurso(Curso curso){
        try {
            course = dao.serachId(curso.getCod());
        } catch (Exception e) {
            System.out.println("Error en ControllerCurso(search): " + e);
        }
    }
    
    public void searchName(){
        try {
            listCurso = dao.listCurso(course.getNombre());
        } catch (Exception e) {
            System.out.println("Error en: " + e);
        }
    }
}
