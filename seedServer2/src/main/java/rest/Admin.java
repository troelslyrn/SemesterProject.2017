package rest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import deploy.DeploymentConfiguration;
import entity.Role;
import facades.UserFacade;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.security.RolesAllowed;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import entity.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.PUT;
import security.PasswordStorage;

@Path("demoadmin")
//@RolesAllowed("Admin")
public class Admin {

    private UserFacade uf;
    private Gson gson;
    User user = new User();
    
    public Admin() {
        
        uf = new UserFacade(Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME));
        
        gson = new Gson();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getSomething() {
        String now = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(new Date());
        return "{\"message\" : \"Hello Admin from server (call accesible by only authenticated ADMINS)\",\n" + "\"serverTime\": \"" + now + "\"}";        
        
    }

    @Path("addUser")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
//  @Consumes(MediaType.APPLICATION_JSON)
    public String addUser(String content) throws PasswordStorage.CannotPerformOperationException {
        JsonObject body = new JsonParser().parse(content).getAsJsonObject();
        System.out.println("ddededuoguyguyuguygyuygu");
        String userName = "";
        String password = "";
//    String userRole ="";
        if (body.has("userName")) {
            userName = body.get("userName").getAsString();
        }
        if (body.has("password")) {
            password = body.get("password").getAsString();
        }

//     if (body.has("userRole"))
//     {
//         userRole= body.get("userRole").getAsString();
//     }
//     User user = null;
//        try {
//            user = new User(userName, password);
//        } catch (PasswordStorage.CannotPerformOperationException ex) {
//            ex.printStackTrace();
//        }
//     uf.addUser(user);
//   return new Gson().toJson(user);
        User user = new User(userName, password);
        user.addRole(uf.getRole("User"));
        uf.addUser(user);
        return new Gson().toJson(user);
    }
    
    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllUsers() {
        //return new Gson().toJson(uf.getUsers());
        List<User> l = uf.getAllUsers();
        JsonArray response = new JsonArray();
        for(User u: l) {
            JsonObject jo = new JsonObject();
            jo.addProperty("userName", u.getUserName());
            JsonArray roles = new JsonArray();
            for(Role r: u.getRoles()) {
                JsonObject ro = new JsonObject();
                ro.addProperty("roleName", r.getRoleName());
                roles.add(ro);
            }
            jo.add("roles", roles);
            response.add(jo);
        }
        return new Gson().toJson(response);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userName}")
    public String deleteUser(@PathParam("userName") String userName) {
        
        User user = uf.deleteUser(userName);
        
        return new Gson().toJson(user);
    }
//  
//     @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//     public String editUser(String content){
//     JsonObject body = new JsonParser().parse(content).getAsJsonObject();
//     User user = uf.editUser(body.get("id").getAsLong());
//       if(body.has("userName"))
//        {
//            user.setUserName(body.get("firstName").getAsString());
//        }
//        if(body.has("password"))
//        {
//            user.setPassword(body.get("password").getAsString());
//        }
//        if(body.has("phoneNumber"))
//        {
//            p.setPhoneNumber(body.get("phoneNumber").getAsInt());
//        }       
//
//        fp.editPerson(p);
//        
//        return new Gson().toJson(p);
//         
//         return null;
//     
//     }
    
}
