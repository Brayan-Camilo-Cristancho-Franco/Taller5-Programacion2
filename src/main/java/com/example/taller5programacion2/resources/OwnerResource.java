package com.example.taller5programacion2.resources;

import com.example.taller5programacion2.resources.pojos.OwnerPojo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usersapp/{username}")

public class OwnerResource {

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("username") String username, OwnerPojo owner) {

        return Response.ok()
                .entity(owner)
                .build();
    }


}
