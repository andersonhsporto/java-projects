package dev.anderson.javaurlshortener.repositories;

import dev.anderson.javaurlshortener.entities.UrlEntity;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends MongoRepository<UrlEntity, String> {

  boolean existsByUrl(String url);

  Optional<UrlEntity> findByShortUrl(String shortUrl);

}
