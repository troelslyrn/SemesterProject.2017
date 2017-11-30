/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Role;
import entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import security.PasswordStorage;

/**
 *
 * @author Troels
 */
public class NewClass22 {
    public static void main(String[] args) throws PasswordStorage.CannotPerformOperationException {
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_development");
     EntityManager em = emf.createEntityManager();
        User user = null;
        user = new User(); //User deleteUser = uf.deleteUser("Troels");
      
        UserFacade uf = new UserFacade(emf);
         Role userRole = em.find(Role.class, "User");
           System.out.println("role!!!!!!!!!!!!!!!!!!!!!!!: "+userRole);
//                         
      
       
//        uf.addUser("troels","123");
       

    }

}

    


