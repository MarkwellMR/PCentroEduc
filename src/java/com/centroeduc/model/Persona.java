
package com.centroeduc.model;

public class Persona {
    private String codigo;
    private String nombre;
    private String apellido;
    private String direccion;
    private String email;
    private Integer telCasa;
    private Integer telMovil;
    private String fechanac;
    private Long cui;
    private String pass;

    public Persona() {
        this.codigo=null;
        this.nombre=null;
        this.apellido=null;
        this.direccion=null;
        this.email=null;
        this.telCasa=null;
        this.telMovil=null;
        this.fechanac=null;
        this.cui=null;
        this.pass=null;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelCasa() {
        return telCasa;
    }

    public void setTelCasa(Integer telCasa) {
        this.telCasa = telCasa;
    }

    public Integer getTelMovil() {
        return telMovil;
    }

    public void setTelMovil(Integer telMovil) {
        this.telMovil = telMovil;
    }

    public String getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    public Long getCui() {
        return cui;
    }

    public void setCui(Long cui) {
        this.cui = cui;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
  
}
