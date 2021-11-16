package com.example.taller5programacion2.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/owners/{username}/pets")
public class PetsResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("username") Integer authorId) {

        List<com.example.taller5programacion2.jpa.entities.resources.pojos.PetPojo> pets = new ArrayList<com.example.taller5programacion2.jpa.entities.resources.pojos.PetPojo>();
        pets.add(new com.example.taller5programacion2.jpa.entities.resources.pojos.PetPojo(1, "Microchip1", "Max","Especie1","Raza1","Pequeño","M","Url1","Owner1"));
        pets.add(new com.example.taller5programacion2.jpa.entities.resources.pojos.PetPojo(2, "Microchip2","Pepe","Especie2","Raza2","Grande","H","Url2","Owner2"));

        return Response.ok()
                .entity(pets)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("username") Integer authorId, com.example.taller5programacion2.jpa.entities.resources.pojos.PetPojo pet) {

        pet.setName("Juan");

        return Response.status(Response.Status.CREATED)
                .entity(pet)
                .build();
    }

}