package com.example.taller5programacion2.resources;

import com.example.taller5programacion2.resources.pojos.VisitPojo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/vets/{username}/pets/{pet_id}/visits/{visit_id}")
public class VisitResource {

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("username") String username, @PathParam("pet_id") Integer pet_id, @PathParam("visit_id") Integer visit_id, VisitPojo visit) {

        Response build = Response.ok()
                .entity(visit)
                .build();
        return build;
    }


}
