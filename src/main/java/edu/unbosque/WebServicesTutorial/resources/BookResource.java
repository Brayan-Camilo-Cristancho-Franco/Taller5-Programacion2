package edu.unbosque.WebServicesTutorial.resources;

import edu.unbosque.WebServicesTutorial.resources.pojos.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/authors/{authorId}/books/{id}")
public class BookResource {

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("authorId") Integer authorId, @PathParam("id") Integer id, Book book) {

        return Response.ok()
                .entity(book)
                .build();
    }

    @DELETE
    public Response delete(@PathParam("authorId") Integer authorId, @PathParam("id") Integer id) {

        return Response.noContent()
                .build();
    }

}
