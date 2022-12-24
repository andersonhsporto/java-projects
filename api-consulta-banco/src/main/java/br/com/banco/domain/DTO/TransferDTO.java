package br.com.banco.domain.DTO;

import br.com.banco.domain.TransferEntity;
import java.text.DecimalFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

@AllArgsConstructor
@Getter
public class TransferDTO {

  private Long id;

  private String transferDate;

  private String value;

  private String type;

  private String operatorName;

  public static TransferDTO fromEntity(TransferEntity transferEntity) {
    return new TransferDTO(
        transferEntity.getId(),
        convertDate(transferEntity.getTransferDate()),
        truncate(transferEntity.getValue()),
        transferEntity.getType(),
        transferEntity.getOperatorName()
    );
  }

  public static List<TransferDTO> fromEntityList(List<TransferEntity> transferEntityList) {
    List<TransferDTO> transferDTOList = new ArrayList<>();

    for (TransferEntity transferEntity : transferEntityList) {
      transferDTOList.add(fromEntity(transferEntity));
    }
    return transferDTOList;
  }

  public static List<TransferDTO> fromEntityPage(Page<TransferEntity> transferEntityList) {
    List<TransferDTO> transferDTOList = new ArrayList<>();

    for (TransferEntity transferEntity : transferEntityList) {
      transferDTOList.add(fromEntity(transferEntity));
    }
    return transferDTOList;
  }


  private static String truncate(double value) {
    String number = new DecimalFormat("#,##0.00").format(value);

    return "R$ " + number;
  }

  private static String convertDate(OffsetDateTime dateToConvert) {
    return DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH).format(dateToConvert);
  }


}
