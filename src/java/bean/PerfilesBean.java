/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.PerfilesDao;
import imp.PerfilesDaoImp;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import model.Perfiles;

/**
 *
 * @author MASTER
 */
@Named(value = "perfilesBean")
@RequestScoped
public class PerfilesBean {

    private List<SelectItem> listPerfiles;
    private Perfiles perfiles;
    
    public PerfilesBean() {
        perfiles = new Perfiles();
    }

    public Perfiles getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(Perfiles perfiles) {
        this.perfiles = perfiles;
    }

    public List<SelectItem> getListPerfiles() {
        this.listPerfiles = new ArrayList<SelectItem>();
        PerfilesDao pDao = new PerfilesDaoImp();
        
        List<Perfiles> p = pDao.listaPerfiles();
        listPerfiles.clear();
        
        for(Perfiles perfiles : p){
            SelectItem perfilesItem = new SelectItem(perfiles.getIdperfil(), perfiles.getNombreperfil());
            this.listPerfiles.add(perfilesItem);
            
        }
        
        return listPerfiles;
    }

    
    
}
