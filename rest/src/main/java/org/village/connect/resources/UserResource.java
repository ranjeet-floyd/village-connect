package org.village.connect.resources;

import org.village.connect.model.Representation;
import org.village.connect.model.UserModel;
import org.village.connect.service.UserService;

import com.codahale.metrics.annotation.Timed;
import org.eclipse.jetty.http.HttpStatus;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * User resource
 * @author ranjeet.kumar
 *
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }
    
    @GET
    @Timed
    public Representation<List<UserModel>> getUsers() {
      return new Representation<List<UserModel>>(HttpStatus.OK_200, userService.getUsers());
    }

    @GET
    @Timed
    @Path("{id}")
    public Representation<UserModel> getUser(@PathParam("id") final int id) {
      return new Representation<UserModel>(HttpStatus.OK_200, userService.getUser(id));
    }

    @POST
    @Timed
    public Representation<UserModel> createUser(@NotNull @Valid final UserModel user) {
      return new Representation<UserModel>(HttpStatus.OK_200, userService.createUser(user));
    }

    @PUT
    @Timed
    @Path("{id}")
    public Representation<UserModel> editPart(@NotNull @Valid final UserModel user,
        @PathParam("id") final int id) {
      user.setId(id);
      return new Representation<UserModel>(HttpStatus.OK_200, userService.editUser(user));
    }

    @DELETE
    @Timed
    @Path("{id}")
    public Representation<String> deleteUser(@PathParam("id") final int id) {
      return new Representation<String>(HttpStatus.OK_200, userService.deleteUser(id));
    }
            
    
    

}
