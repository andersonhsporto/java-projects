package dev.anderson.userapi.users.web;

import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.fasterxml.jackson.core.JsonParseException;
import dev.anderson.userapi.users.exceptions.UserNotFoundExcepton;

@RestControllerAdvice
public class GeneralExceptionHandler {
  
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
      List<String> errors = ex.getBindingResult()
              .getFieldErrors()
              .stream()
              .map(FieldError::getDefaultMessage).collect(Collectors.toList());

      return new ResponseEntity<>(getErrorsMap(errors), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  private ResponseEntity<Object> handleConflict(DataIntegrityViolationException ex) {
    List<String> errors = Collections.singletonList("The user already exists, try again with a unique username");
    
    return new ResponseEntity<>(getErrorsMap(errors), HttpStatus.CONFLICT);
  }

  @ExceptionHandler(UserNotFoundExcepton.class)
  private ResponseEntity<Map<String, List<String>>> handleUserNotFound(UserNotFoundExcepton ex) {
    List<String> errors = Collections.singletonList(ex.getMessage());
    
    return new ResponseEntity<>(getErrorsMap(errors), HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler({DateTimeParseException.class, JsonParseException.class})
  private ResponseEntity<Map<String, List<String>>> handleDateParseError(Exception ex) {
    List<String> errors = Collections.singletonList(ex.getMessage());
    
    return new ResponseEntity<>(getErrorsMap(errors), HttpStatus.BAD_REQUEST);
  }

  private Map<String, List<String>> getErrorsMap(List<String> errors) {
    Map<String, List<String>> errorsMap = new HashMap<>();
    
    errorsMap.put("errors", errors);
    return errorsMap;
  }
}
