package com.example.taller5programacion2.resources;


import com.example.taller5programacion2.resources.pojos.UserAppPojo;
import com.example.taller5programacion2.services.OfficialService;
import com.example.taller5programacion2.services.OwnerService;
import com.example.taller5programacion2.services.UserAppService;
import com.example.taller5programacion2.services.VetService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/usersapp")

public class UsersAppResource {


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(UserAppPojo userapp) {
        if (userapp.getOwnerPojo() != null) {
            new UserAppService().saveUserApp(userapp.getUsername(), userapp.getPassword(), userapp.getEmail(), userapp.getRole());
            new OwnerService().saveOwner(userapp.getUsername(), userapp.getOwnerPojo().getPerson_id(), userapp.getOwnerPojo().getName(), userapp.getOwnerPojo().getAdress(), userapp.getOwnerPojo().getNeighborhood());
        } else if (userapp.getOfficialPojo() != null) {
            new UserAppService().saveUserApp(userapp.getUsername(), userapp.getPassword(), userapp.getEmail(), userapp.getRole());
            new OfficialService().saveOfficial(userapp.getOfficialPojo().getUsername(), userapp.getOfficialPojo().getName());
        } else if (userapp.getVetPojo() != null) {
            new UserAppService().saveUserApp(userapp.getUsername(), userapp.getPassword(), userapp.getEmail(), userapp.getRole());
            new VetService().saveVet(userapp.getVetPojo().getName(), userapp.getVetPojo().getAdress(), userapp.getVetPojo().getNeighborhood(), userapp.getVetPojo().getUsername());
        }

        return Response.status(Response.Status.CREATED)
                .entity(userapp)
                .build();
    }
}
