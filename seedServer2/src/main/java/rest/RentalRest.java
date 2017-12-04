package rest;

import com.google.gson.Gson;
import deploy.DeploymentConfiguration;
import entity.Rental;
import facades.RentalFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/rentals")
public class RentalRest {

   private RentalFacade rentalFacade;
   private Rental rental;
   Gson gson;
   
   public RentalRest() {
        rentalFacade = new RentalFacade(Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME));
        gson = new Gson();
    }
   
   @GET
    @Produces(MediaType.APPLICATION_JSON)
   public Response getAllRentals(){
       List<Rental> rentals = rentalFacade.getAllRentals();
       GenericEntity<List<Rental>> rentalWrapper = new GenericEntity<List<Rental>>(rentals){};
       return Response.ok(rentalWrapper).build();
   }
   
}
