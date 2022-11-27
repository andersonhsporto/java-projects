package dev.anderson.javaurlshortener.services;

import dev.anderson.javaurlshortener.Dtos.UrlDto;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

  public String createUrl(UrlDto urlDto) {
    return "http://localhost:8080/";
  }

}
