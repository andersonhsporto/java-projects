package dev.anderson.livraria.service;

import dev.anderson.livraria.entity.LivroEntity;
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
    return livrariaRepository.findByNameAndYear(name, year);
  }

  public void deleteBook(Long id) {
    livrariaRepository.deleteById(id);
  }

  public LivroEntity updateBook(Long id, LivroEntity livro) {
    LivroEntity livroEntity = livrariaRepository.findById(id).get();
    livroEntity.update(livro);
    return livrariaRepository.save(livroEntity);
  }


}
