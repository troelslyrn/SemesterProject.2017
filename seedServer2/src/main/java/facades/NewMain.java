//
//import deploy.DeploymentConfiguration;
//import entity.Role;
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
//     // EntityManagerFactory emf =Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME) ;
//      
// 
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) throws PasswordStorage.CannotPerformOperationException {
//     EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_development");
//     EntityManager em = emf.createEntityManager();
//        User user = null;
//        user = new User(); //User deleteUser = uf.deleteUser("Troels");
//      
//        UserFacade uf = new UserFacade(emf);
//         Role userRole = em.find(Role.class, "User");
//           System.out.println("role: "+userRole);
////                         
//      
//       
////        uf.addUser("troels","123");
//       
//
//    }
//
//}
