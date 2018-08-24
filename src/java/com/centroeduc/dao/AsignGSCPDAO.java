
package com.centroeduc.dao;

import com.centroeduc.model.AsignacionGSCP;
import com.centroeduc.model.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AsignGSCPDAO extends Conexion{
    private String sql;
    private PreparedStatement run;
    private String answer;
    ResultSet values;
    
    AsignacionGSCP asign = new AsignacionGSCP();
    
    public String newAsing(){
        answer = null;
        try {
            this.Conectar();
            sql = "insert into cursgradsecprof(cod_grad, cod_sec, cod_curso, cod_prof) values(?,?,?,?)";
            run = this.getMiconexion().prepareStatement(sql);
            run.setInt(1, this.asign.getCdGrado());
            run.setInt(2, this.asign.getCdSecc());
            run.setInt(3, this.asign.getCdCurso());
            run.setString(4, this.asign.getCdMaestro());
            run.executeUpdate();
            
            answer = "Asignacion Realizada con Exito";
             run.close();
            
        } catch (SQLException e) {
            System.out.println("Error al asignar: " + e);
            answer="No se pudo realizar la Asignacion";
        }finally{
            this.cerrarConex();
        }
        return answer;
    }
    
}
