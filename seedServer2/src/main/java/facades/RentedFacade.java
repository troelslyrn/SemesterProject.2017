/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Rented;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import security.IRentedFacade;

/**
 *
 * @author Troels
 */
public class RentedFacade implements IRentedFacade  {

    
     EntityManagerFactory emf;

    public RentedFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }
     
    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public List<Rented> getAllRented() {
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery("SELECT rented FROM Rented rented").getResultList();
        } finally {
            em.close();
        }

    }

    @Override
    public Rented addRented(Rented rented) {
        {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(rented);

            em.getTransaction().commit();

            return rented;
        } finally {
            em.close();
        }
    }
    }

    @Override
    public Rented DeleteRented(Integer idrenting) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Rented rented = em.find(Rented.class, idrenting);
            em.remove(rented);
            em.getTransaction().commit();
            return rented;
        } finally {
            em.close();
        }
    }
    
}
