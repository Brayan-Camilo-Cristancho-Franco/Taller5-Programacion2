package com.example.taller5programacion2.jpa.entities.resources;


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

        List<com.example.taller5programacion2.jpa.entities.resources.pojos.PetCasePojo> petcase = new ArrayList<com.example.taller5programacion2.jpa.entities.resources.pojos.PetCasePojo>();
        petcase.add(new com.example.taller5programacion2.jpa.entities.resources.pojos.PetCasePojo(1, "Fecha1", "Perdida", "Perdida descripcion",1));
        petcase.add(new com.example.taller5programacion2.jpa.entities.resources.pojos.PetCasePojo(2, "Fecha2", "Fallecimiento", "Fallecimiento descripcion",2));

        return Response.ok()
                .entity(petcase)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("pet_id") Integer pet_id, com.example.taller5programacion2.jpa.entities.resources.pojos.PetCasePojo petcase) {

        petcase.setDescription("perdida descripcion");

        return Response.status(Response.Status.CREATED)
                .entity(petcase)
                .build();
    }
}
