package dev.anderson.livraria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class DuplicatedBookException extends HttpClientErrorException {

  public DuplicatedBookException(HttpStatus status, String statusText) {
    super(status, statusText);
  }

}
