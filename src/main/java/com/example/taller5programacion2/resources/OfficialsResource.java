package com.example.taller5programacion2.jpa.entities.resources;

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

        List<com.example.taller5programacion2.jpa.entities.resources.pojos.OfficialPojo> officials = new ArrayList<com.example.taller5programacion2.jpa.entities.resources.pojos.OfficialPojo>();
        officials.add(new com.example.taller5programacion2.jpa.entities.resources.pojos.OfficialPojo("pepe", "Gabriel Garcia Marquez"));
        officials.add(new com.example.taller5programacion2.jpa.entities.resources.pojos.OfficialPojo("pedro", "Jorge Isaacs"));

        return Response.ok()
                .entity(officials)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(com.example.taller5programacion2.jpa.entities.resources.pojos.OfficialPojo official) {

        official.setUsername("pepito");

        return Response.status(Response.Status.CREATED)
                .entity(official)
                .build();
    }
}
