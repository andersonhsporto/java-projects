package dev.anderson.livraria.controller;

import dev.anderson.livraria.entity.LivroEntity;
import dev.anderson.livraria.service.LivrariaService;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/livraria/livros")
@AllArgsConstructor
public class LivrariaController {

  private final LivrariaService livrariaService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public LivroEntity cadastraLivro(@Valid @RequestBody LivroEntity livro) {
    return livrariaService.insertBook(livro);

  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<LivroEntity> getAllbooks() {
    return livrariaService.getAllBooks();
  }

  @GetMapping("/find")
  @ResponseStatus(HttpStatus.OK)
  public LivroEntity getBookByNameAndYear(@PathVariable String name, @PathVariable Integer year) {
    return livrariaService.getBookByNameAndYear(name, year);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteBook(@PathVariable Long id) {
    livrariaService.deleteBook(id);
  }

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public LivroEntity updateBook(@PathVariable Long id, @RequestBody LivroEntity livro) {
    return livrariaService.updateBook(id, livro);
  }


}
