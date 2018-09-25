package com.centroeduc.dao;

import com.centroeduc.model.Administrador;
import com.centroeduc.model.AlumnoGrado;
import com.centroeduc.model.Notas;
import com.centroeduc.model.Secretaria;
import com.centroeduc.model.Unidad;
import java.util.ArrayList;

public class prueba {

    public static void main(String[] args) {

        Secretaria secre = new Secretaria();
        SecreDao dao = new SecreDao();
        Administrador adm = new Administrador();
        Notas nota = new Notas();
        Unidad unidad = new Unidad();
        AlumnoGrado alumGrad = new AlumnoGrado();
        NotasDAO notasdao = new NotasDAO();
        ArrayList<Notas> listaNotas = new ArrayList();
        listaNotas = notasdao.MostrarNotas();
        
      
       
        

//  dao.nuevaSecretaria(secre, adm);
    //dao.editarSecretaria(secre);
   // dao.estado(secre);
    
        
        
        
        

    }

}
