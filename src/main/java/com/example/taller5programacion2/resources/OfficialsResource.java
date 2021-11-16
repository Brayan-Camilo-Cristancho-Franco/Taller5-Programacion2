package com.example.taller5programacion2.resources;

import com.example.taller5programacion2.jpa.entities.Official;
import com.example.taller5programacion2.resources.pojos.OfficialPojo;
import com.example.taller5programacion2.services.OfficialService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/usersapp/officials")

public class OfficialsResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {

        List<OfficialPojo> officials = new ArrayList<OfficialPojo>();
        officials.add(new OfficialPojo("pepe", "Gabriel Garcia Marquez"));
        officials.add(new OfficialPojo("pedro", "Jorge Isaacs"));

        return Response.ok()
                .entity(officials)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(OfficialPojo official) {

        Official persistedOfficial = new OfficialService().saveOfficial(official.getUsername(), official.getName());


        return Response.status(Response.Status.CREATED)
                .entity(official)
                .build();
    }
}
