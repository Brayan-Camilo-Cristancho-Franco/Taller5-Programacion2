package com.example.taller5programacion2.resources;


import com.example.taller5programacion2.resources.pojos.PetCasePojo;
import com.example.taller5programacion2.services.PetCaseService;
import com.example.taller5programacion2.services.PetService;
import com.example.taller5programacion2.services.VisitService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/petscase")
public class PetsCaseResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/pet/{pet_id}")
    public Response list(@PathParam("pet_id") Integer authorId) {

        List<PetCasePojo> petcase = new ArrayList<PetCasePojo>();
        petcase.add(new PetCasePojo(1, null, "Perdida", "Perdida descripcion", 1));
        petcase.add(new PetCasePojo(2, null, "Fallecimiento", "Fallecimiento descripcion", 2));

        return Response.ok()
                .entity(petcase)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response create(PetCasePojo petcase) {


        new PetCaseService().savePetCase(petcase.getCreated_at(),petcase.getType(), petcase.getDescription(), petcase.getPet_id());


        if (petcase.getType().equals("Perdida")||petcase.getType().equals("Robo")||petcase.getType().equals("Fallecimiento")) {

            if (petcase != null) {
                return Response.status(Response.Status.CREATED)
                        .entity(petcase)
                        .build();
            } else {
                return Response.serverError()
                        .entity("Owner user could not be created")
                        .build();
            }
        } else {
            return Response.serverError()
                    .entity("Owner user could not be created")
                    .build();

        }


    }
}
