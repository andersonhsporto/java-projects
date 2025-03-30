package dev.anderson.javaurlshortener.controllers;

import dev.anderson.javaurlshortener.Dtos.UrlDto;
import dev.anderson.javaurlshortener.services.Implementation.UrlServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/urls")
public class UrlController {

  private final UrlServiceImpl urlService;

  public UrlController(UrlServiceImpl urlService) {
    this.urlService = urlService;
  }

  @PostMapping
  public String shortenUrl(@RequestBody UrlDto urlDto) {
    System.out.println(urlDto.url());
    return urlService.shortenUrl(urlDto);
  }

  @GetMapping
  public ResponseEntity<?> handleUrl(@RequestBody UrlDto urlDto) {
    return urlService.handleUrl(urlDto);
  }

}
