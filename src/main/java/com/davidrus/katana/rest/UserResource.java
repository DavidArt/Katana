package com.davidrus.katana.rest;

import com.davidrus.katana.dto.User;
import com.davidrus.katana.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by david on 12-May-17.
 */

@Slf4j
@Path(RestConstants.USER_PATH)
@Controller
public class UserResource {

    @Resource
    UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        if (userService.createUser(user)) {
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.accepted().build();
    }

    @GET
    @Transactional
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserName(@PathParam("id") Long id) {
        User user = userService.getUser(id);
        if (user != null) {
            return Response.ok().entity(user).build();
        }
        return Response.accepted().build();
    }

    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserName(@QueryParam("name") String name) {
        User user = userService.getUserByName(name);
        if (user != null) {
            return Response.ok().entity(user).build();
        }
        return Response.accepted().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(User user) {
        if(userService.updateUser(user)) {
            return Response.noContent().build();
        }
        return Response.accepted().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        if (userService.deleteUser(id)) {
            return Response.noContent().build();
        }
        return Response.accepted().build();
    }
}
