/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import entity.Rented;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Troels
 */
public interface IRentedFacade {
    public void addEntityManagerFactory(EntityManagerFactory emf);
  public EntityManager getEntityManager();
  
  public List<Rented> getAllRented();
  public Rented addRented (Rented rented);
  public Rented DeleteRented (Integer idrenting);
  
}
