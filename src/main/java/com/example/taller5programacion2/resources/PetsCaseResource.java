package com.example.taller5programacion2.resources;


import com.example.taller5programacion2.resources.pojos.PetCasePojo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/pets/{pet_id}/petscase")
public class PetsCaseResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("pet_id") Integer authorId) {

        List<PetCasePojo> petcase = new ArrayList<PetCasePojo>();
        petcase.add(new PetCasePojo(1, null, "Perdida", "Perdida descripcion", 1));
        petcase.add(new PetCasePojo(2, null, "Fallecimiento", "Fallecimiento descripcion", 2));

        return Response.ok()
                .entity(petcase)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("pet_id") Integer pet_id, PetCasePojo petcase) {

        petcase.setDescription("perdida descripcion");

        return Response.status(Response.Status.CREATED)
                .entity(petcase)
                .build();
    }
}
