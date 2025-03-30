package org.sed.escolaapi.course.web;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.sed.escolaapi.course.domain.CourseDTO;
import org.sed.escolaapi.course.domain.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/curso")
public class CourseController {

  private final CourseService courseService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<CourseDTO> getCourses() {
    return courseService.getCourses();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public CourseDTO getCourseById(@PathVariable Long id) throws EntityNotFoundException {
    return courseService.getCourseById(id);
  }

  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public CourseDTO createCourse(@RequestBody @Valid CourseDTO course) throws BadRequestException {
    return courseService.createCourse(course);
  }

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public CourseDTO updateCourse(@PathVariable Long id, @RequestBody @Valid CourseDTO course)
      throws EntityNotFoundException {
    return courseService.updateCourse(id, course);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCourse(@PathVariable Long id) throws EntityNotFoundException {
    courseService.deleteCourse(id);
  }

  @ExceptionHandler(BadRequestException.class)
  public String badRequestExceptionHandler(BadRequestException e) {
    log.info("Requisição inválida {}", e.getMessage());
    return e.getMessage();
  }

  @ExceptionHandler(EntityNotFoundException.class)
  public String entityNotFoundExceptionHandler(EntityNotFoundException e) {
    log.info("Entidade não encontrada {}", e.getMessage());
    return "Curso não encontrado";
  }

}
