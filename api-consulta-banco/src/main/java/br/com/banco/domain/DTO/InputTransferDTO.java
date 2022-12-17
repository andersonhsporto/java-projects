package br.com.banco.domain.DTO;

import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InputTransferDTO {

  private OffsetDateTime initialDate;

  private OffsetDateTime finalDate;

  private String operatorName;

  private Long transferId;

  public boolean isValidOperatorName() {
    return operatorName != null && !operatorName.isEmpty();
  }

}
