package dev.anderson.livraria.controller;

import dev.anderson.livraria.exception.BookNotFoundException;
import dev.anderson.livraria.exception.DuplicatedBookException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({
      BookNotFoundException.class,
      DuplicatedBookException.class
  })
  protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
    return handleExceptionInternal(
        ex,
        ex.getMessage(),
        new HttpHeaders(),
        HttpStatus.BAD_REQUEST,
        request
    );
  }

}
