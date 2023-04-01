package dev.anderson.resource;

import dev.anderson.entities.BookEntity;
import dev.anderson.exceptions.BookNotFoundException;
import dev.anderson.service.BookService;
import org.jboss.resteasy.reactive.ResponseStatus;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/v1/livraria/livros")
public class BookResource {

    @Inject
    BookService bookService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ResponseStatus(201)
    public BookEntity makeBook(BookEntity book) {
        return bookService.makeBook(book);
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAll() {
        return bookService.getAllBooks().toString();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BookEntity getBook(@PathParam("id") Long id) throws BookNotFoundException {
        return bookService.getBook(id);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public BookEntity updateBook(@PathParam("id") Long id, BookEntity book) throws BookNotFoundException {
        return bookService.updateBook(id, book);
    }

    @DELETE
    @Path("/{id}")
    @ResponseStatus(200)
    @Produces(MediaType.TEXT_PLAIN)
    public void deleteBook(@PathParam("id") Long id) throws BookNotFoundException {
        bookService.deleteBook(id);
    }
}