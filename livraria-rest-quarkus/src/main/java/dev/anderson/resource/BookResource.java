package dev.anderson.resource;

import dev.anderson.entities.BookEntity;
import dev.anderson.service.BookService;
import org.jboss.resteasy.reactive.ResponseStatus;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}