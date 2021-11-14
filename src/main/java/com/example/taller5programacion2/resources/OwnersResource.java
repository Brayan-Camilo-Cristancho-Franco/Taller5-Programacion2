package com.example.taller5programacion2.jpa.entities.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/usersapp/owners")
public class OwnersResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {

        List<com.example.taller5programacion2.jpa.entities.resources.pojos.OwnerPojo> owners = new ArrayList<com.example.taller5programacion2.jpa.entities.resources.pojos.OwnerPojo>();
        owners.add(new com.example.taller5programacion2.jpa.entities.resources.pojos.OwnerPojo("pepe",1, "Gabriel Garcia Marquez","calle 15 # 65-56","gaitan"));
        owners.add(new com.example.taller5programacion2.jpa.entities.resources.pojos.OwnerPojo("Pably",2, "Pablo Neruda","calle 48 # 75-86","normandia"));

        return Response.ok()
                .entity(owners)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(com.example.taller5programacion2.jpa.entities.resources.pojos.OwnerPojo owner) {

        owner.setUsername("pablo");

        return Response.status(Response.Status.CREATED)
                .entity(owner)
                .build();
    }
}
