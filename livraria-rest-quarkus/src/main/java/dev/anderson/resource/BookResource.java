package dev.anderson.resource;

import dev.anderson.entities.BookEntity;
import dev.anderson.service.BookService;
import org.jboss.resteasy.reactive.ResponseStatus;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/v1/livraria/livros")
public class BookResource {

    private final BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
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
    public BookEntity getBook(@PathParam("id") Long id) {
        return bookService.getBook(id);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BookEntity updateBook(@PathParam("id") Long id, BookEntity book) {
        return bookService.updateBook(id, book);
    }

    @DELETE
    @Path("/{id}")
    @ResponseStatus(204)
    public void deleteBook(@PathParam("id") Long id) {
        bookService.deleteBook(id);
    }
}