package com.centroeduc.dao;

import com.centroeduc.model.Administrador;
import com.centroeduc.model.Secretaria;

public class prueba {

    public static void main(String[] args) {

        Secretaria secre = new Secretaria();
        SecreDao dao = new SecreDao();
        Administrador adm = new Administrador();


        secre.setDireccion("SDFEE");
        secre.setNombre("HENRY");
        secre.setApellido("Marroquin");
        secre.setCui(Long.parseLong("123456789"));
        secre.setEmail("dora@gmail.com");
        secre.setCodigo("S0013");
        secre.setEstado(1);
        secre.setFechanac("2018/08/23");
        secre.setTelCasa(123456);
        secre.setTelMovil(123459);
        secre.setPass("12345DAF");
        adm.setCodigo("A0001");
        
        
//  dao.nuevaSecretaria(secre, adm);
    //dao.editarSecretaria(secre);
    dao.estado(secre);
    
        
        
        
        

    }

}
