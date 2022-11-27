package dev.anderson.javaurlshortener.services;

import dev.anderson.javaurlshortener.Dtos.UrlDto;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

public interface UrlService {

  public String shortenUrl(UrlDto url);

  public String hashUrl(String url);

  public ResponseEntity<?> handleUrl(UrlDto url);

}
