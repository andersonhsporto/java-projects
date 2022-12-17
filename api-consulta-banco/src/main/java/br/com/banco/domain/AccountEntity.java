package br.com.banco.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "conta")
public class AccountEntity {

  @Id
  @Column(name = "idConta", nullable = false, updatable = false)
  @SequenceGenerator(
      name = "primary_sequence",
      sequenceName = "primary_sequence",
      allocationSize = 1,
      initialValue = 10000
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "primary_sequence"
  )
  private Long id;

  @Column(name = "nomeResponsavel", nullable = false, length = 50)
  private String name;

  @OneToMany(mappedBy = "conta")
  private List<TransferEntity> accountTransfers;

}
