
package com.centroeduc.controller;

import com.centroeduc.dao.AdminDAO;
import com.centroeduc.model.Administrador;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.ToggleEvent;

@ManagedBean
@ViewScoped
public class ControllerAdmin {
    ArrayList<Administrador> listAdmin = new ArrayList();
    AdminDAO dao = new AdminDAO();
    Administrador admin = new Administrador();

    public ArrayList<Administrador> getListAdmin() {
        return listAdmin;
    }

    public void setListAdmin(ArrayList<Administrador> listAdmin) {
        this.listAdmin = listAdmin;
    }
    
    public void loadAdmin(){
        listAdmin= dao.listAdmin();
    }
    
    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }
    
    public void saveAdmin(){
        try {
            dao.registerAdmin(admin);
        } catch (Exception e) {
            System.out.println("Error ControllerAdmin(save): " + e);
        }
    }
    
    public void searchAdmin(Administrador datos){
        try {
            admin = dao.searchId(datos.getCodigo());
        } catch (Exception e) {
            System.out.println("Error ControllerAdmin(search): " + e);
        }
    }
    public void updateAdmin(){
        
        try {
            dao.updateAdmin(admin);
        } catch (Exception e) {
            System.out.println("Error ControllerAdmin(update): " + e);
        }
    }
    
    public void changeState(){
        try {
            dao.changeState(admin);
        } catch (Exception e) {
            System.out.println("Error ControllerAdmin(change): " + e);
        }
}
    
    
    
    //mensaje :v
//    public void handleToggle(ToggleEvent event) {
//        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Toggled", "Visibility:" + event.getVisibility());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
}
