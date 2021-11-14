package com.example.taller5programacion2.jpa.entities.resources;

import com.example.taller5programacion2.jpa.entities.resources.pojos.Visit;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/vets/{username}/pets/{pet_id}/visits")
public class VisitsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("username") String username,@PathParam("pet_id") Integer pet_id) {

        List<Visit> visit = new ArrayList<Visit>();
        visit.add(new Visit(1, "Fecha1", "Vacunacion", "Vacunacion descripcion",username,pet_id));
        visit.add(new Visit(2, "Fecha2", "Esterilizacion", "Esterilizacion descripcion",username,pet_id));

        return Response.ok()
                .entity(visit)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("username") String username,@PathParam("pet_id") Integer pet_id, Visit visit) {

        visit.setDescription("Nueva descripcion");

        return Response.status(Response.Status.CREATED)
                .entity(visit)
                .build();
    }
}