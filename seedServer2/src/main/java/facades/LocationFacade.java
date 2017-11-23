/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Location;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import security.ILocationfacade;

/**
 *
 * @author Troels
 */
public class LocationFacade implements ILocationfacade{
    EntityManagerFactory emf;
     List<Location> location;
    
    
    public LocationFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }
    

    
    
    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf) {
        
    }

    @Override
    public EntityManager getEntityManager() {
         return emf.createEntityManager();
    }

    @Override
    public Location addLocation(Location location) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(location);

            em.getTransaction().commit();

            return location;
        } finally {
            em.close();
        }
    }

    @Override
    public Location editLocation(Location location) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Location l = em.find(Location.class, location.getIdlocation());
            if (location != null) {
                l = location;
                em.merge(l);
                em.getTransaction().commit();
                return l;
            }
        } finally {
            em.close();
        }

        return null;
    }

    @Override
    public Location deleteLocation(Integer idlocation) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Location location = em.find(Location.class, idlocation );
            em.remove(location);
            em.getTransaction().commit();
            return location;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Location> getallLocations() {
        EntityManager em = emf.createEntityManager();

        try {
            return em.createNamedQuery("Location.findAll").getResultList();
        } finally {
            em.close();
        }

    }
    
}
