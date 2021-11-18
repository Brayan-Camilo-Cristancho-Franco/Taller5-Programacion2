package com.example.taller5programacion2.resources;


import com.example.taller5programacion2.resources.pojos.UserAppPojo;
import com.example.taller5programacion2.services.OfficialService;
import com.example.taller5programacion2.services.OwnerService;
import com.example.taller5programacion2.services.UserAppService;
import com.example.taller5programacion2.services.VetService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usersapp/{username}")
public class UserAppResource {

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify( @PathParam("username") String username, UserAppPojo userApp, String email, String name, String address, String neighborhood) {

        if (userApp.getOwnerPojo() != null) {
            new UserAppService().updateUserApp(username, userApp.getEmail());
            new OwnerService().updateOwner(username, userApp.getOwnerPojo().getName(), userApp.getOwnerPojo().getAdress(), userApp.getOwnerPojo().getNeighborhood());
        } else if (userApp.getOfficialPojo() != null) {
            new UserAppService().updateUserApp(username, userApp.getEmail());
            new OfficialService().updateOfficial(username, userApp.getOwnerPojo().getName());
        } else if (userApp.getVetPojo() != null) {
            new UserAppService().updateUserApp(username, userApp.getEmail());
            new VetService().updateVet(username, userApp.getOwnerPojo().getName(), userApp.getOwnerPojo().getAdress(), userApp.getOwnerPojo().getNeighborhood());
        }

        return Response.ok()
                .entity(userApp)
                .build();
    }


}