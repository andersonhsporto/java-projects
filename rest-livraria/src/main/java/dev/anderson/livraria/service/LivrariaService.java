package dev.anderson.livraria.service;

import dev.anderson.livraria.entity.LivroEntity;
import dev.anderson.livraria.exception.BookNotFoundException;
import dev.anderson.livraria.exception.DuplicatedBookException;
import dev.anderson.livraria.repository.LivrariaRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LivrariaService {

  private LivrariaRepository livrariaRepository;

  public LivroEntity insertBook(LivroEntity livro) {
    if (livrariaRepository.existsByNameAndYear(livro.getName(), livro.getYear())) {
      throw new DuplicatedBookException(HttpStatus.BAD_REQUEST, "Livro já cadastrado");
    } else {
      return livrariaRepository.save(livro);
    }
  }

  public List<LivroEntity> getAllBooks() {
    return livrariaRepository.findAll();
  }

  public LivroEntity getBookByNameAndYear(String name, Integer year) {
    if (!livrariaRepository.existsByNameAndYear(name, year)) {
      throw new BookNotFoundException(HttpStatus.BAD_REQUEST, "Livro não encontrado");
    }
    return livrariaRepository.findByNameAndYear(name, year);
  }

  public void deleteBook(Long id) {
    if (!livrariaRepository.existsById(id)) {
      throw new BookNotFoundException(HttpStatus.BAD_REQUEST, "Livro não encontrado");
    }
    livrariaRepository.deleteById(id);
  }

  public LivroEntity updateBook(Long id, LivroEntity livro) {
    validateUpdateBook(id, livro);
    LivroEntity livroEntity = livrariaRepository.findById(id).get();

    livroEntity.update(livro);
    return livrariaRepository.save(livroEntity);
  }

  private void validateUpdateBook(Long id, LivroEntity livro) {
    if (!livrariaRepository.existsById(id)) {
      throw new BookNotFoundException(HttpStatus.BAD_REQUEST, "Livro não encontrado");
    } else if (livrariaRepository.existsByNameAndYear(livro.getName(), livro.getYear())) {
      throw new DuplicatedBookException(HttpStatus.BAD_REQUEST, "Já existe um livro com esse nome e ano");
    }
  }


}
