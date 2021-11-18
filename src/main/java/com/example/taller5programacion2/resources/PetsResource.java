package com.example.taller5programacion2.resources;

import com.example.taller5programacion2.jpa.entities.Official;
import com.example.taller5programacion2.jpa.entities.Pet;
import com.example.taller5programacion2.resources.pojos.PetPojo;
import com.example.taller5programacion2.services.OfficialService;
import com.example.taller5programacion2.services.PetService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Path("/owners/{username}/pets")
public class PetsResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("username") Integer authorId) {

        List<PetPojo> pets = new ArrayList<PetPojo>();
        pets.add(new PetPojo(1, "Microchip1", "Max", "Especie1", "Raza1", "Pequeño", "M", "Url1", "Owner1"));
        pets.add(new PetPojo(2, "Microchip2", "Pepe", "Especie2", "Raza2", "Grande", "H", "Url2", "Owner2"));

        return Response.ok()
                .entity(pets)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(PetPojo petpojo) {


        new PetService().savePet(petpojo.getMicrochip(), petpojo.getName(), petpojo.getSpecies(), petpojo.getRace(), petpojo.getSize(), petpojo.getSex(), petpojo.getPicture());

        if (petpojo != null) {
            return Response.status(Response.Status.CREATED)
                    .entity(petpojo)
                    .build();
        } else {
            return Response.serverError()
                    .entity("Owner user could not be created")
                    .build();
        }

    }

    @PUT
    @Path("/pets/{pet_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("username") String username, @PathParam("pet_id") Integer pet_id, PetPojo pet) {

        return Response.ok()
                .entity(pet)
                .build();
    }
}