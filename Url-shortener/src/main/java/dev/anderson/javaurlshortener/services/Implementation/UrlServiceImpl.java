package dev.anderson.javaurlshortener.services.Implementation;

import dev.anderson.javaurlshortener.Dtos.UrlDto;
import dev.anderson.javaurlshortener.services.UrlService;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl implements UrlService {

  @Override
  public String shortenUrl(UrlDto url) {
    return null;
  }
}
