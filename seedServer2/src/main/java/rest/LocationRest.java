 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import deploy.DeploymentConfiguration;
import entity.Cities;
import entity.Location;
import facades.LocationFacade;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import mapper.LocationMapper;

/**
 * REST Web Service
 *
 * @author Troels
 */
@Path("LocationRest")
public class LocationRest {

    private LocationFacade lf;
    private Gson gson;
    Location location = new Location();
    Cities city = new Cities();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LocationRest
     */
    public LocationRest() {
        lf = new LocationFacade(Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME));
        gson = new Gson();
    }

    /**
     * Retrieves representation of an instance of rest.LocationRest
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of LocationRest
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }

//    @Path("AddLocation")
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public String addLocation(String content) {
//    JsonObject body = new JsonParser().parse(content).getAsJsonObject();
//         
//        String street = "";
//        String description = "";
//        Integer housenr = null;
//        Integer zip = null;
//        byte[] img = null;
//        Integer idlocation = null;
//        Integer  idrating = null;
//        String username ="";
//                
//        
//        
//        
//       if (body.has("street")) {
//            street = body.get("street").getAsString();
//        }
//       if (body.has("description")) {
//            description = body.get("description").getAsString();
//        }
//       if (body.has("housenr")) {
//            housenr = body.get("housenr").getAsInt();
//        }
//       if (body.has("zip")) {
//            zip = body.get("zip").getAsInt();
//        }
////       if (body.has("img")) {
////            img = body.get("img").getAsString();
////       }
//       Location location = null;
//      
//       location = new Location(idlocation, description, housenr, img, street, idrating, username, zip);
//       
//       
//       
//       //Location location = new Location ();
//       lf.addLocation(location);
//       return new Gson().toJson(location);
//
//    }
    
    
        @Path("AddLocation")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addLocation(String content) {
        JsonObject body = new JsonParser().parse(content).getAsJsonObject();

        String street = "";
        String description = "";
        int housenr=0;
        int zip=0;
        
        
       if (body.has("street")) {
            street = body.get("street").getAsString();
        }
       if (body.has("description")) {
            description = body.get("description").getAsString();
        }
       if (body.has("housenr")) {
            description = body.get("housenr").getAsString();
        }
       if (body.has("zip")) {
            description = body.get("zip").getAsString();
        }
       Location l = new Location();
       l.setDescription(description);
       l.setHousenr(housenr);
       l.setIdlocation(zip);
       l.setStreet(street);
       lf.addLocation(l);
       return gson.toJson(l);

    }
    
    
  @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{location}")
    public String deleteUser(@PathParam("location") Integer idlocation) {
        
        Location location = lf.deleteLocation(idlocation);
        
        return new Gson().toJson(location);
    }
    
//    @Path("all")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getAllLocations(){
//    {
//        //return new Gson().toJson(uf.getUsers());
//        List<Location> l = lf.getallLocations();
//        JsonArray response = new JsonArray();
//        for(Location location: l) {
//            JsonObject jo = new JsonObject();
//            jo.addProperty("Location", location.getIdlocation());
//            JsonArray roles = new JsonArray();
////            for(Role r: u.getRoles()) {
////                JsonObject ro = new JsonObject();
////                ro.addProperty("roleName", r.getRoleName());
////                roles.add(ro);
////            }
////            jo.add("roles", roles);
////            response.add(jo);
//        }
//        return new Gson().toJson(response);
//    }
//    
//    }
//    
     @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllLocations(){
      List<Location> locations = lf.getallLocations();
        return gson.toJson(new LocationMapper(locations,true));
     
     }

}
