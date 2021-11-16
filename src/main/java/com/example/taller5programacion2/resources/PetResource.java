package com.example.taller5programacion2.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/owner/{username}/pets/{pet_id}")
public class PetResource {


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("username") String username, @PathParam("pet_id") Integer pet_id, com.example.taller5programacion2.jpa.entities.resources.pojos.PetPojo pet) {

        return Response.ok()
                .entity(pet)
                .build();
    }

    @DELETE
    public Response delete(@PathParam("username") Integer authorId, @PathParam("pet_id") Integer id) {

        return Response.noContent()
                .build();
    }

}