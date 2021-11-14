package com.example.taller5programacion2.jpa.entities.resources;

import com.example.taller5programacion2.jpa.entities.resources.pojos.Vet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/vets")
public class VetsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {

        List<Vet> authors = new ArrayList<Vet>();
        authors.add(new Vet("Veterinaria1", "Nombre veterinaria 1","Direccion1","Vecindario1"));
        authors.add(new Vet("Veterinaria2", "Nombre veterinaria 2","Direccion2","Vecindario2"));

        return Response.ok()
                .entity(authors)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Vet vet) {

        vet.setUsername("veterinaria3");

        return Response.status(Response.Status.CREATED)
                .entity(vet)
                .build();
    }

}
