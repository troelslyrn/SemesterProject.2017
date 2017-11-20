/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package rest;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import deploy.DeploymentConfiguration;
//import entity.Adress;
//import facades.AdressFacade;
//import javax.persistence.Persistence;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.UriInfo;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
//import javax.ws.rs.Produces;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.PUT;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.core.MediaType;
//
///**
// * REST Web Service
// *
// * @author Troels
// */
//@Path("generic")
//public class AdressRest  {
//
//    private AdressFacade af;
//    private Gson gson;
//    Adress adress = new Adress();
//    @Context
//    private UriInfo context;
//
//    /**
//     * Creates a new instance of AdressRest
//     */
//    public AdressRest() {
//        af = new AdressFacade (Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME));
//        gson = new Gson();
//    }
//
//    /**
//     * Retrieves representation of an instance of rest.AdressRest
//     * @return an instance of java.lang.String
//     */
//    @GET
//    @Produces(MediaType.APPLICATION_XML)
//    public String getXml() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }
//
//    /**
//     * PUT method for updating or creating an instance of AdressRest
//     * @param content representation for the resource
//     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_XML)
//    public void putXml(String content) {
//    }
//
//@Path("addAdress")
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//public String addAdress(String content){
//JsonObject body = new JsonParser().parse(content).getAsJsonObject();
// String city = "";
// int zip = "";
// String street = "";
// Integer housenr = "";
//  if (body.has("city")) {
//            city = body.get("city").getAsString();
//        }
//   if (body.has("street")) {
//            street = body.get("street").getAsString();
//        }
//    if (body.has("zip")) {
//            zip = body.get("zip").getAsInt();
//        }
//     if (body.has("housenr")) {
//            housenr = body.get("housenr").getAsInt();
//        }
//
//     Adress adrres = new Adress(city,zip,street,housenr);
//     af.addAdress(adress);
//      return new Gson().toJson(adress);
//     
//}
// @DELETE
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/{userName}")
//    public String deleteUser(@PathParam("userName") String userName) {
//        
//        Adress adress = af.deleteAdress(addressID);
//        
//        return new Gson().toJson(adress);
//    }
//
//
//
//
//
//}
