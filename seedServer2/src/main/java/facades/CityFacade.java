/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Cities;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import security.iCity;

/**
 *
 * @author mre44
 */
public class CityFacade implements iCity {
     EntityManagerFactory emf;
     
     public CityFacade(EntityManagerFactory emf){
         this.emf = emf;
     }

    @Override
    public Cities addCity(Cities city) {
        EntityManager em = emf.createEntityManager();
        
        try{
            em.getTransaction().begin();;
            em.persist(city);
            em.getTransaction().commit();
            
            return city;
        }finally {
            em.close();
        }
    }
}
