package dev.anderson.livraria.entity;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LivroEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String name;

  @NotNull
  private Integer year;

  public void update(LivroEntity livro) {
    this.name = livro.name;
    this.year = livro.year;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LivroEntity that = (LivroEntity) o;
    return Objects.equals(id, that.id) && Objects.equals(name, that.name)
        && Objects.equals(year, that.year);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, year);
  }
}
