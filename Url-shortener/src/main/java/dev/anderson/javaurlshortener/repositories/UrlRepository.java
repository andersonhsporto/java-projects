package dev.anderson.javaurlshortener.repositories;

import dev.anderson.javaurlshortener.entities.UrlEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public class UrlRepository extends MongoRepository<UrlEntity, String> {

}
