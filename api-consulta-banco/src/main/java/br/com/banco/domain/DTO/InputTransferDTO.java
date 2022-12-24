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

  private Long id;

  private Integer page;

  private Integer size;

  private OffsetDateTime initialDate;

  private OffsetDateTime finalDate;

  private String operatorName;

  public static InputTransferDTO of(
      Long id,
      Integer page,
      Integer size,
      String initialDate,
      String finalDate,
      String operatorName
  ) {
    return new InputTransferDTO(
        id,
        page,
        size,
        parseDate(initialDate),
        parseDate(finalDate),
        parseName(operatorName));
  }

  public boolean isValidOperatorName() {
    return operatorName != null && !operatorName.isEmpty();
  }

  public boolean isValidDate() {
    return initialDate != null && finalDate != null;
  }

  public boolean isValidNameAndDate() {
    return isValidOperatorName() && isValidDate();
  }

  private static OffsetDateTime parseDate(String date) {
    if (date.equals("1990-12-20T00:00:00Z")) {
      return null;
    }
    return OffsetDateTime.parse(date);
  }

  private static String parseName(String name) {
    if (name.equals("null")) {
      return null;
    }
    return name;
  }

}
