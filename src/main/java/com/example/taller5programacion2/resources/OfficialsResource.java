package com.example.taller5programacion2.jpa.entities.resources;

import com.example.taller5programacion2.jpa.entities.resources.pojos.Official;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

    @Path("/usersapp/officials")

public class OfficialsResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
        public Response list() {

        List<Official> officials = new ArrayList<Official>();
        officials.add(new Official("pepe", "Gabriel Garcia Marquez"));
        officials.add(new Official("pedro", "Jorge Isaacs"));

        return Response.ok()
                .entity(officials)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Official official) {

        official.setUsername("pepito");

        return Response.status(Response.Status.CREATED)
                .entity(official)
                .build();
    }
}
