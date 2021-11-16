package com.example.taller5programacion2.resources;

import com.example.taller5programacion2.resources.pojos.UserAppPojo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/usersapp/{rol}/usersapp")

public class UsersAppResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("rol") String rol) {

        List<UserAppPojo> usersapp = new ArrayList<UserAppPojo>();
        usersapp.add(new UserAppPojo("pepe", "a123","hdfd@gmail.com","Owner"));
        usersapp.add(new UserAppPojo("fer", "b321","dsfdsf@gmail.com","Official"));

        return Response.ok()
                .entity(usersapp)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(UserAppPojo userapp) {

        userapp.setUsername("Username");

        return Response.status(Response.Status.CREATED)
                .entity(userapp)
                .build();
    }
}
