package com.example.taller5programacion2.resources;

import com.example.taller5programacion2.resources.pojos.Owner;
import com.example.taller5programacion2.resources.pojos.UserApp;

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

        List<UserApp> usersapp = new ArrayList<UserApp>();
        usersapp.add(new UserApp("pepe", "a123","hdfd@gmail.com","Owner"));
        usersapp.add(new UserApp("fer", "b321","dsfdsf@gmail.com","Official"));

        return Response.ok()
                .entity(usersapp)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(UserApp userapp) {

        userapp.setUsername("elbrayan");

        return Response.status(Response.Status.CREATED)
                .entity(userapp)
                .build();
    }
}
