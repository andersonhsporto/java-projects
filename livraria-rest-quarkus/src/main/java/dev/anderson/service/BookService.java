package dev.anderson.service;

import dev.anderson.exceptions.BookNotFoundException;
import dev.anderson.repository.BookRepository;
import dev.anderson.entities.BookEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class BookService {
    private final BookRepository bookRepository;

    @Inject
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookEntity makeBook(BookEntity book) {
        book.setPromotionalPrice();
        bookRepository.persist(book);
        return book;
    }

    public BookEntity getBook(Long id) {
        return bookRepository.findByIdOptional(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    public List<BookEntity> getAllBooks() {
        return bookRepository.listAll();
    }

    public BookEntity updateBook(Long id, BookEntity book) {
        BookEntity bookEntity = bookRepository.findByIdOptional(id).orElseThrow(() -> new BookNotFoundException(id));
        bookEntity.setUnitsInStock(book.getUnitsInStock());
        bookEntity.setStatus(book.getStatus());
        bookEntity.setPromotionalPrice();
        bookRepository.persist(bookEntity);
        return bookEntity;
    }

    public void deleteBook(Long id) {
        BookEntity bookEntity = bookRepository.findByIdOptional(id).orElseThrow(() -> new BookNotFoundException(id));
        bookRepository.delete(bookEntity);
    }

}
