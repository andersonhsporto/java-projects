package br.com.banco.domain;

import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "transferencia")
public class TransferEntity {

  @Id
  @Column(nullable = false, updatable = false)
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

  @Column(name = "dataTransferencia", nullable = false)
  private OffsetDateTime transferDate;

  @Column(name = "valor", nullable = false, precision = 22, scale = 2)
  private float value;

  @Column(name = "tipo", nullable = false, length = 15)
  private String type;

  @Column(name = "nomeOperadorTransacao", length = 50)
  private String operatorName;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "conta_id", nullable = false)
  private AccountEntity conta;
}
