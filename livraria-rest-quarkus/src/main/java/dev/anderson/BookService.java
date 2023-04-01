package dev.anderson;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookEntity makeBook(BookEntity book) {
        book.setPromotionalPrice();
        bookRepository.persist(book);
        return book;
    }
}
