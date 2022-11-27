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

  private String shortUrl;

  private LocalDateTime createdAt;

  public UrlEntity() {
  }

  public UrlEntity(String url, LocalDateTime createdAt) {
    this.url = url;
    this.createdAt = createdAt;
  }

  public UrlEntity(String url, String shortUrl, LocalDateTime createdAt) {
    this.url = url;
    this.shortUrl = shortUrl;
    this.createdAt = createdAt;
  }

  public static UrlEntity fromDto(UrlDto urlDto) {
    return new UrlEntity(
        urlDto.url(),
        LocalDateTime.now()
    );
  }

  public static UrlEntity fromDtoAndString(UrlDto urlDto, String shortUrl) {
    return new UrlEntity(
        urlDto.url(),
        shortUrl,
        LocalDateTime.now()
    );
  }

  public String getId() {
    return id;
  }

  public String getUrl() {
    return url;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public String getShortUrl() {
    return shortUrl;
  }

  @Override
  public String toString() {
    return "UrlEntity { " +
        "id ='" + id + '\'' +
        ", url ='" + url + '\'' +
        ", shortUrl ='" + shortUrl + '\'' +
        ", createdAt =" + createdAt +
        '}';
  }
}
