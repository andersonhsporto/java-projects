package com.api.sacolaapi.models;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@Embeddable
@NoArgsConstructor
public class Endereco {

  private String rua;

  private String cidade;

  private String cep;

  private String complemento;

}
