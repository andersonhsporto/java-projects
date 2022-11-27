package dev.anderson.javaurlshortener.entities;

import dev.anderson.javaurlshortener.Dtos.UrlDto;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "urls")
public class UrlEntity {

  @Id
  private String id;

  private String url;

  private LocalDateTime createdAt;


  public UrlEntity() {

  }

  public UrlEntity(String url) {
    this.url = url;
    this.createdAt = LocalDateTime.now();
  }

  public static UrlEntity fromDto(UrlDto urlDto) {
    return new UrlEntity(urlDto.url());
  }

  @Override
  public String toString() {
    return "UrlEntity {" +
        "id = '" + id + '\'' +
        ", url = '" + url + '\'' +
        ", createdAt = " + createdAt +
        '}';
  }
}
