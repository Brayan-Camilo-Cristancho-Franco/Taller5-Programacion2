package com.example.taller5programacion2.resources;

import com.example.taller5programacion2.resources.pojos.OfficialPojo;
import com.example.taller5programacion2.services.OfficialService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/officials")
public class OfficialResource {

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{username}")
    public Response modify(@PathParam("username") String username,String name, OfficialPojo official) {
        Optional<OfficialPojo> updatedOfficial = new OfficialService().updateUserApp(username,name);
        return Response.ok()
                .entity(official)
                .build();
    }


}

