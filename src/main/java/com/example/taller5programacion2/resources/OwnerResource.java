package com.example.taller5programacion2.jpa.entities.resources;

import com.example.taller5programacion2.jpa.entities.resources.pojos.Owner;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usersapp/{username}")

public class OwnerResource {

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("username")String username, Owner owner) {

        return Response.ok()
                .entity(owner)
                .build();
    }

    @DELETE
    public Response delete(@PathParam("username") String username) {

        return Response.noContent()
                .build();
    }
}
