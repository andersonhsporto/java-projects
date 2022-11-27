package dev.anderson.javaurlshortener.services.Implementation;

import com.google.common.hash.Hashing;
import dev.anderson.javaurlshortener.Dtos.UrlDto;
import dev.anderson.javaurlshortener.entities.UrlEntity;
import dev.anderson.javaurlshortener.repositories.UrlRepository;
import dev.anderson.javaurlshortener.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl implements UrlService {

  @Autowired
  private UrlRepository urlRepository;

  @Override
  public String shortenUrl(UrlDto urlDto) {

    if (urlRepository.existsByUrl(urlDto.url())) {
      return "Url already exists";
    } else {
      var hashString = hashUrl(urlDto.url());
      var urlEntity = UrlEntity.fromDtoAndString(urlDto, hashString);

      urlRepository.save(urlEntity);
      return hashString;
    }
  }

  @Override
  public String hashUrl(String url) {
    String hashString = Hashing
        .murmur3_32_fixed()
        .hashBytes(url.getBytes()).toString();

    System.out.println("TESTE " + hashString);
    return hashString;
  }

  @Override
  public ResponseEntity<?> handleUrl(UrlDto urlDto) {
    var urlEntity = urlRepository.findByShortUrl(urlDto.url());

    if (urlEntity.isPresent()) {
      return ResponseEntity.ok(urlEntity.get().getUrl());
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}




