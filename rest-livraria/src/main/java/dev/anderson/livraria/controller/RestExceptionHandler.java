package dev.anderson.livraria.controller;

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

  @ExceptionHandler(value = {DuplicatedBookException.class})
  protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
    String bodyOfResponse = "Livro já cadastrado";

    return handleExceptionInternal(
        ex,
        bodyOfResponse,
        new HttpHeaders(),
        HttpStatus.BAD_REQUEST,
        request
    );
  }

}
