/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author memo_
 */
public class admindaoimplement {
      
    public List<Usuarios> getListaAdmin(String usuario, String password){
   //simplificar en una linea 
        
        Conexion conexion = new Conexion("35.202.122.108","prueba","root","1234");
        Connection cnn = conexion.getConexion();
        List<Usuarios> lista = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement psmt;
        try {
            psmt = cnn.prepareStatement("call get_usuario(?,?)");
            psmt.setString(1, usuario);
            psmt.setString(2, password);
            rs = psmt.executeQuery();   
  //simplificar en una linea 
            
            while(rs.next()){
            Usuarios d = new Usuarios();
            d.setUsuario(rs.getString("usuario"));
            d.setPassword(rs.getString("password"));
            lista.add(d);
        }
        } catch (SQLException ex) {
            Logger.getLogger(admindaoimplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
}
