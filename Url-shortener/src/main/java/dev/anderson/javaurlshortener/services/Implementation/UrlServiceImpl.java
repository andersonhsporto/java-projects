package dev.anderson.javaurlshortener.services.Implementation;

import dev.anderson.javaurlshortener.Dtos.UrlDto;
import dev.anderson.javaurlshortener.entities.UrlEntity;
import dev.anderson.javaurlshortener.repositories.UrlRepository;
import dev.anderson.javaurlshortener.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl implements UrlService {

  @Autowired
  private UrlRepository urlRepository;

  @Override
  public String shortenUrl(UrlDto url) {

    var urlEntity = UrlEntity.fromDto(url);

    urlRepository.save(urlEntity);
    return "Entity saved";
  }
}
