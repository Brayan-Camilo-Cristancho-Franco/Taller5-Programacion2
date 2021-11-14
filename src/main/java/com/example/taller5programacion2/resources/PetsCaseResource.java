package com.example.taller5programacion2.jpa.entities.resources;


import com.example.taller5programacion2.jpa.entities.resources.pojos.PetCase;

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

        List<PetCase> petcase = new ArrayList<PetCase>();
        petcase.add(new PetCase(1, "Fecha1", "Perdida", "Perdida descripcion",1));
        petcase.add(new PetCase(2, "Fecha2", "Fallecimiento", "Fallecimiento descripcion",2));

        return Response.ok()
                .entity(petcase)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("pet_id") Integer pet_id, PetCase petcase) {

        petcase.setDescription("perdida descripcion");

        return Response.status(Response.Status.CREATED)
                .entity(petcase)
                .build();
    }
}
