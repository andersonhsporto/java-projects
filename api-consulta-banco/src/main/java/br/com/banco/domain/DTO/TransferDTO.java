package br.com.banco.domain.DTO;

import br.com.banco.domain.TransferEntity;
import java.text.DecimalFormat;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TransferDTO {

  private Long id;

  private OffsetDateTime transferDate;

  private float value;

  private String type;

  private String operatorName;

  public static TransferDTO fromEntity(TransferEntity transferEntity) {
    return new TransferDTO(
        transferEntity.getId(),
        transferEntity.getTransferDate(),
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

  private static float truncate(float value) {
    DecimalFormat twoDForm = new DecimalFormat("#.##");

    return Float.valueOf(twoDForm.format(value));
  }


}
