package br.com.banco.DTO;

import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InputTransferDTO {

  private OffsetDateTime initialDate;

  private OffsetDateTime finalDate;

  private String operatorName;

}
