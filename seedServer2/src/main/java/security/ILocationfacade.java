/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import entity.Location;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Troels
 */
public interface ILocationfacade {
    public void addEntityManagerFactory(EntityManagerFactory emf);
    public EntityManager getEntityManager();
    public Location addLocation (Location location);
    public Location editLocation (Location location);
    public Location deleteLocation (Integer idlocation );
    public List<Location> getallLocations ();
            
}
