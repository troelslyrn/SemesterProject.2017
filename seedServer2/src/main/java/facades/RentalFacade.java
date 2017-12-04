package facades;

import entity.Rental;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class RentalFacade {

    EntityManagerFactory emf;

    public RentalFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Rental addRental(Rental rental){
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();

            em.persist(rental);

            em.getTransaction().commit();

            return rental;
        } finally {
            em.close();
        }
    }

    public Rental editRental(Rental rental) {
        EntityManager em = emf.createEntityManager();
        
        try{
            em.getTransaction().begin();
        Rental oldRental = em.find(Rental.class, rental.getId());
        if(rental != null) {
            rental = oldRental;
            em.merge(rental);
            em.getTransaction().commit();
            return rental;
        }
        return null; }
        
        finally {
            em.close();
        }
    }
        
        public Rental deleteRental(Long id){
            EntityManager em = emf.createEntityManager();

            try {
                em.getTransaction().begin();
                Rental rental = em.find(Rental.class, id);
                if(rental != null)
                {
                    em.remove(rental);
                    em.getTransaction().commit();
                    return rental;
                }
                
                return null;
                
            } finally {
                em.close();
            }
        }
        
        
        
        
        public List<Rental> getAllRentals() {
            EntityManager em = emf.createEntityManager();
            
            try {
                List<Rental> rentals = em.createQuery(
            "SELECT r FROM Rental r").getResultList();
                return rentals;
                
            } finally {
            em.close();
            }
        }
}
