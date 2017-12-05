package rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import deploy.DeploymentConfiguration;
import entity.Rental;
import facades.RentalFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
   public String getAllRentals(){
       List<Rental> rentals = rentalFacade.getAllRentals();
     //  GenericEntity<List<Rental>> rentalWrapper = new GenericEntity<List<Rental>>(rentals){};
      // return Response.ok(rentals).build();
         return gson.toJson(rentals);
   }
   
   @POST
   @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
   public String addRental(String content){
               JsonObject body = new JsonParser().parse(content).getAsJsonObject();
               
               String city = "";
               String description = "";
               String street = "";
               Float latitude = null;
               Float longitude = null;
               int rating = 0;
               int streetNumber = 0;
               String userName = "";
               String zip = "";
               
               if (body.has("city")) {
                 city = body.get("city").getAsString();
               } 
               
                if (body.has("description")) {
                    description = body.get("description").getAsString();
                }
                
                if (body.has("street")) {
                    street = body.get("street").getAsString();
        }
                if (body.has("latitude")) {
                latitude = body.get("latitude").getAsFloat();
        }
                if(body.has("longitude")){
                   longitude = body.get("longitude").getAsFloat();
                }
                
                if (body.has("rating")) {
                rating = body.get("rating").getAsInt();
        }
                if (body.has("streetNumber")) {
            streetNumber = body.get("streetNumber").getAsInt();
        }
                if (body.has("userName")) {
            userName = body.get("userName").getAsString();
        }
                if (body.has("zip")) {
            zip = body.get("zip").getAsString();
        }
               Rental rental = new Rental();
               
               rental.setCity(city);
               rental.setDescription(description);
               rental.setLatitude(latitude);
               rental.setLongitude(longitude);
               rental.setRating(rating);
               rental.setStreet(street);
               rental.setStreetNumber(streetNumber);
               rental.setUserName(userName);
               rental.setZip(zip);
               rentalFacade.addRental(rental);
               return gson.toJson(rental);
              
               
               
               
  
   }
   
}
