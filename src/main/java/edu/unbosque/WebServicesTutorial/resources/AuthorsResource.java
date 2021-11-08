package edu.unbosque.WebServicesTutorial.resources;

import edu.unbosque.WebServicesTutorial.resources.pojos.Author;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.List;

@Path("/authors")
public class AuthorsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {

        List<Author> authors = new ArrayList<Author>();
        authors.add(new Author(1, "Gabriel Garcia Marquez"));
        authors.add(new Author(2, "Jorge Isaacs"));

        return Response.ok()
                .entity(authors)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Author author) {

        author.setAuthorId(3);

        return Response.status(Response.Status.CREATED)
                .entity(author)
                .build();
    }

}
