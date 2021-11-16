package com.example.taller5programacion2.resources;


import com.example.taller5programacion2.resources.pojos.PetCasePojo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pet/{pet_id}/petscase/{case_id}")
public class PetCaseResource {

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("pet_id") Integer pet_id, @PathParam("case_id") Integer case_id, PetCasePojo petcase) {

        return Response.ok()
                .entity(petcase)
                .build();
    }

}