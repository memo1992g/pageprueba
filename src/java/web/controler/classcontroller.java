/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controler;

import model.admindaoimplement;
import dao.admindao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author memo_
 */
@ManagedBean
@RequestScoped
public class classcontroller {
public String usuario; 
public String password;
private String mensaje ="bienvenido";

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
 private List<admindao> lista = new ArrayList<>();

 admindaoimplement admin = new admindaoimplement();  


public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<admindao> getLista() {
        return lista;
    }

    public void setLista(List<admindao> lista) {
        this.lista = lista;
    }


    

    
    

    
    
   
    public String val(){
        lista = admin.getListaAdmin(usuario,password);
        if (lista.size() >0 ){
       
            
           
            return "bienvenido.xhtml";
            
        
        
    }else {
            return "error.xhtml";
        }
      
    }
    
}
