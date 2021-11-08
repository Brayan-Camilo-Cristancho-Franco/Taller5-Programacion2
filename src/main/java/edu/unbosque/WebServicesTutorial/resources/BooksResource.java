package edu.unbosque.WebServicesTutorial.resources;

import edu.unbosque.WebServicesTutorial.resources.pojos.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/authors/{authorId}/books")
public class BooksResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("authorId") Integer authorId) {

        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "Cien años de soledad", "1234", authorId));
        books.add(new Book(2, "El coronel no tiene quien le escriba", "1234", authorId));

        return Response.ok()
                .entity(books)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("authorId") Integer authorId, Book book) {

        book.setBookId(3);

        return Response.status(Response.Status.CREATED)
                .entity(book)
                .build();
    }

}
