package dev.anderson.repository;

import dev.anderson.entities.BookEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookRepository implements PanacheRepository<BookEntity> {
}
