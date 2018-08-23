package com.centroeduc.dao;

import com.centroeduc.model.Conexion;
import com.centroeduc.model.Encargado;
import com.centroeduc.model.Secretaria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EncargadoDAO extends Conexion {

    private String sql;
    private PreparedStatement run;
    private String answer;
    ResultSet resultado;
    //agregar un nuevo Administrador 

    Encargado encargado = new Encargado();
    Secretaria secre = new Secretaria();

    public String nuevoEncargado(Encargado encargado, Secretaria secre) {
        answer = null;
        try {
            this.Conectar();
            System.out.println("dao encargado");
            sql = "insert into encargado values(?,?,?,?,?,?,?,?,?,?,?)";
            run = this.getMiconexion().prepareStatement(sql);
            run.setString(1, encargado.getCodigo());
            run.setString(2, encargado.getNombre());
            run.setString(3, encargado.getApellido());
            run.setString(4, encargado.getDireccion());
            run.setString(5, encargado.getEmail());
            run.setInt(6, encargado.getTelCasa());
            run.setInt(7, encargado.getTelMovil());
            run.setString(8, encargado.getFechanac());
            run.setLong(9, encargado.getCui());
            run.setInt(10, 1);
            run.setString(11, secre.getCodigo());

            System.out.println(encargado.toString());
            System.out.println(secre.toString());

            run.executeUpdate();
            answer = "Dato almacenado";
        } catch (SQLException e) {
            answer = "dato no guardado" + e;
        } finally {
            this.cerrarConex();
        }
        return answer;
    }

    public ArrayList<Encargado> MostarEncargado() {
        ArrayList<Encargado> lista = null;
        try {
            this.Conectar();
            sql = "select * from encargado where estado=1";
            run = this.getMiconexion().prepareStatement(sql);
            resultado = run.executeQuery();
            lista = new ArrayList();
            while (resultado.next()) {
                Encargado enc = new Encargado();
                enc.setCodigo(resultado.getString("cod_enc"));
                enc.setNombre(resultado.getString("nombre"));
                enc.setApellido(resultado.getString("apellido"));
                enc.setDireccion(resultado.getString("direccion"));
                enc.setEmail(resultado.getString("email"));
                enc.setTelCasa(resultado.getInt("tel_casa"));
                enc.setTelMovil(resultado.getInt("tel_movil"));
                enc.setFechanac(resultado.getString("fechanac"));
                enc.setCui(resultado.getLong("cui"));
                lista.add(enc);

            }
        } catch (SQLException e) {
            System.out.println("Error" + e);
        } finally {
            this.cerrarConex();
        }
        return lista;
    }

    public String delEnc(String codigo) {
        answer = null;
        try {
            this.Conectar();
            sql = "delete from encargado where cod_enc=?";
            run = this.getMiconexion().prepareStatement(sql);
            run.setString(1, codigo);
            run.executeUpdate();
            answer = "registro eliminado";

        } catch (SQLException ex) {
            System.out.println("Error en conexion:" + ex);
        } finally {
            this.cerrarConex();
        }
        return answer;
    }

    public String UpEnc(Encargado encargado) {
        try {
            this.Conectar();
            sql = "update encargado set nombre=?, apellido=?, direccion=?, email=?, tel_casa=?, tel_movil=?, fechanac=?, cui=? where cod_enc=?";
            run = this.getMiconexion().prepareStatement(sql);

            run.setString(1, encargado.getNombre());
            run.setString(2, encargado.getApellido());
            run.setString(3, encargado.getDireccion());
            run.setString(4, encargado.getEmail());
            run.setInt(5, encargado.getTelCasa());
            run.setInt(6, encargado.getTelMovil());
            run.setString(7, encargado.getFechanac());
            run.setLong(8, encargado.getCui());
            run.setString(9, encargado.getCodigo());
            run.executeUpdate();
            answer = "Registro Actualizado";

        } catch (SQLException ex) {
            System.out.println("Error en conexion " + ex);
            answer = "error en conexion " + ex;
        } finally {
            this.cerrarConex();
        }

        return answer;
    }

    public Encargado searchId(String codigo) {
        Encargado enc = new Encargado();
        try {
            this.Conectar();
            sql = "select * from encargado where cod_enc=?";
            run = this.getMiconexion().prepareStatement(sql);
            run.setString(1, codigo);
            this.resultado = this.run.executeQuery();
            if (this.resultado.next()) {
                enc.setCodigo(this.resultado.getString("cod_enc"));
                enc.setNombre(this.resultado.getString("nombre"));
                enc.setApellido(this.resultado.getString("apellido"));
                enc.setDireccion(this.resultado.getString("direccion"));
                enc.setEmail(this.resultado.getString("email"));
                enc.setTelCasa(this.resultado.getInt("tel_casa"));
                enc.setTelMovil(this.resultado.getInt("tel_movil"));
                enc.setFechanac(this.resultado.getString("fechanac"));
                enc.setCui(this.resultado.getLong("cui"));
            } else {
                System.out.println("Registro no Encontrado");
            }
            resultado.close();
            this.run.close();
        } catch (SQLException e) {
            System.out.println("error en Search " + e);
        } finally {
            this.cerrarConex();
        }
        return enc;
    }
    public String cambioEstado(Encargado enc){
        try {
            this.Conectar();
            sql = "update estado =2 where cod_enc=?";
            run = this.getMiconexion().prepareStatement(sql);
             run.setString(1, enc.getCodigo());
             
             run.executeUpdate();
             answer = "registro eliminado exitosamente";
             
             run.close();    
        } catch (SQLException e) {
            answer = "No se pudo actualizar ";
            System.out.println("Error en actualizar " + e);
        }finally{
            this.cerrarConex();
           
        }
        return answer;
    }

}
