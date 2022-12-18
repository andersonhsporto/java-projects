package br.com.banco.domain.DTO;

import br.com.banco.domain.AccountEntity;
import br.com.banco.domain.TransferEntity;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AccountDTO {

  private String accountName;

  private Long accountId;

  private float balance;

  private List<TransferDTO> transferDTOList;

  public static AccountDTO fromEntity(AccountEntity accountEntity) {
    return new AccountDTO(
        accountEntity.getName(),
        accountEntity.getId(),
        calculateBalance(accountEntity.getAccountTransfers()),
        TransferDTO.fromEntityList(accountEntity.getAccountTransfers())
    );
  }

  public static List<AccountDTO> fromEntityList(List<AccountEntity> accountEntityList) {
    List<AccountDTO> accountDTOList = new ArrayList<>();

    for (AccountEntity accountEntity : accountEntityList) {
      accountDTOList.add(fromEntity(accountEntity));
    }
    return accountDTOList;
  }

  private static float calculateBalance(List<TransferEntity> transferDTOList) {
    float balance = 0;
    for (TransferEntity transferEntity : transferDTOList) {
      balance += transferEntity.getValue();
    }
    return balance;
  }

}
