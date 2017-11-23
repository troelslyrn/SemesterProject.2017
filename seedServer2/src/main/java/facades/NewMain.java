/////*
//// * To change this license header, choose License Headers in Project Properties.
//// * To change this template file, choose Tools | Templates
//// * and open the template in the editor.
//// */
////package facades;
////
//import entity.User;
//import facades.UserFacade;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import security.PasswordStorage;
//
///**
// *
// * @author Troels
// */
//public class NewMain {
//
//    
//    
//
//    
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) throws PasswordStorage.CannotPerformOperationException {
//        User user = null;
//        user = new User("troels", "123"); //User deleteUser = uf.deleteUser("Troels");
//       EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_development");
//        UserFacade uf = new UserFacade(emf);
//      
//       
////        uf.addUser("troels","123");
//       
//
//    }
//
//}
