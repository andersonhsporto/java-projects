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


}
