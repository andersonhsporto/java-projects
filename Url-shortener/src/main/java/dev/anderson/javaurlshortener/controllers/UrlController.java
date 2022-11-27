package dev.anderson.javaurlshortener.controllers;

import dev.anderson.javaurlshortener.Dtos.UrlDto;
import dev.anderson.javaurlshortener.services.UrlService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/urls")
public class UrlController {

  private final UrlService urlService;

  public UrlController(UrlService urlService) {
    this.urlService = urlService;
  }

  @PostMapping
  public String createUrl(@RequestBody UrlDto urlDto) {
    return urlService.createUrl(urlDto);
  }


}
