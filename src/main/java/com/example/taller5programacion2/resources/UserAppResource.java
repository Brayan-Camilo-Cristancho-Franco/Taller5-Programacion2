package com.example.taller5programacion2.resources;

import com.example.taller5programacion2.resources.pojos.UserApp;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usersapp/{username}")
public class UserAppResource {

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("username") String username, UserApp userApp) {

        return Response.ok()
                .entity(userApp)
                .build();
    }

    @DELETE
    public Response delete(@PathParam("username") String username) {

        return Response.noContent()
                .build();
    }
}
