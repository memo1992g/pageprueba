/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imp;

import dao.PerfilesDao;
import java.util.List;
import model.Perfiles;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author MASTER
 */
public class PerfilesDaoImp implements PerfilesDao {
    
    @Override
    public List<Perfiles> listaPerfiles(){
        List<Perfiles> listarPerfiles=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        
        String hql="FROM Perfiles";
        
        try{
            listarPerfiles = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            t.rollback();
        }
            
        return listarPerfiles;
}
    
    
}
