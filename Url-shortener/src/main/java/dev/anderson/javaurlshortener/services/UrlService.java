package dev.anderson.javaurlshortener.services;

import dev.anderson.javaurlshortener.Dtos.UrlDto;

public interface UrlService {

  public String shortenUrl(UrlDto url);

}
