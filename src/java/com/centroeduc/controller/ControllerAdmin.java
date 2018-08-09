
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

    public ArrayList<Administrador> getListAdmin() {
        return listAdmin;
    }

    public void setListAdmin(ArrayList<Administrador> listAdmin) {
        this.listAdmin = listAdmin;
    }
    
    public void loadAdmin(){
        AdminDAO dao = new AdminDAO();
        listAdmin= dao.listAdmin();
    }
    
    Administrador admin = new Administrador();

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }
    
    public void saveAdmin(){
        AdminDAO dao = new AdminDAO();
        try {
            dao.registerAdmin(admin);
        } catch (Exception e) {
            System.out.println("Error ControllerAdmin(save): " + e);
        }
    }
    
    public void searchAdmin(Administrador datos){
        AdminDAO dao = new AdminDAO();
        try {
            admin = dao.searchId(datos.getCodigo());
        } catch (Exception e) {
            System.out.println("Error ControllerAdmin(search): " + e);
        }
    }
    public void updateAdmin(){
        AdminDAO dao = new AdminDAO();
        try {
            dao.updateAdmin(admin);
        } catch (Exception e) {
            System.out.println("Error ControllerAdmin(update): " + e);
        }
    }
    
    public void deleteAdmin(){
        AdminDAO dao = new AdminDAO();
        try {
            dao.deleteAdmin(admin.getCodigo());
        } catch (Exception e) {
            System.out.println("Error en ControllerAdmin(delete): " + e);
        }
    }
    
    //mensaje :v
//    public void handleToggle(ToggleEvent event) {
//        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Toggled", "Visibility:" + event.getVisibility());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
}
