/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package facades;
//
//import entity.Adress;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import security.IAdressFacade;
//
///**
// *
// * @author Troels
// */
//public class AdressFacade implements IAdressFacade {
//
//      EntityManagerFactory emf;
//
//    public AdressFacade(EntityManagerFactory emf) {
//        this.emf = emf;
//    }
//     
//    @Override
//    public void addEntityManagerFactory(EntityManagerFactory emf) {
//    }
//
//    @Override
//    public EntityManager getEntityManager() {
//         return emf.createEntityManager();
//    }
//
//    @Override
//    public Adress addAdress(Adress adress) {
//        EntityManager em = emf.createEntityManager();
//
//        try {
//            em.getTransaction().begin();
//
//            em.persist(adress);
//
//            em.getTransaction().commit();
//
//            return adress;
//        } finally {
//            em.close();
//        }
//    }
//
//    @Override
//    public Adress deleteAdress(int adressID) {
//        EntityManager em = emf.createEntityManager();
//
//        try {
//            em.getTransaction().begin();
//            Adress adress = em.find(Adress.class, adressID );
//            em.remove(adress);
//            em.getTransaction().commit();
//            return adress;
//        } finally {
//            em.close();
//        }
//    }
//    @Override
//    public List<Adress> getallAdress() {
//        EntityManager em = emf.createEntityManager();
//
//        try {
//            return em.createQuery("SELECT adress FROM Adress adress").getResultList();
//        } finally {
//            em.close();
//        }
//
//    }
//
//    @Override
//    public Adress editAdress(Adress adress) {
//        EntityManager em = emf.createEntityManager();
//
//        try {
//            em.getTransaction().begin();
//            Adress a = em.find(Adress.class, user.getUserName());
//            if (adress != null) {
//                a = adress;
//                em.merge(a);
//                em.getTransaction().commit();
//                return a;
//            }
//        } finally {
//            em.close();
//        }
//
//        return null;
//    }
//    
//}
