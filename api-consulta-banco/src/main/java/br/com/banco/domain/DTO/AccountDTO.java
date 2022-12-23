package br.com.banco.domain.DTO;

import br.com.banco.domain.AccountEntity;
import br.com.banco.domain.TransferEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

@AllArgsConstructor
@Getter
public class AccountDTO {

  private String accountName;

  private Long accountId;

  private float balance;

  private float balanceInPeriod;

  private List<TransferDTO> transfers;

  public static AccountDTO fromEntity(
      AccountEntity accountEntity,
      InputTransferDTO inputTransferDTO
  ) {
    return new AccountDTO(
        accountEntity.getName(),
        accountEntity.getId(),
        calculateBalance(accountEntity.getAccountTransfers()),
        calculateBalanceP(accountEntity, inputTransferDTO),
        TransferDTO.fromEntityList(accountEntity.getAccountTransfers())
    );
  }

  public static AccountDTO fromEntityAndPage(
      AccountEntity accountEntity,
      Page<TransferEntity> transferEntities,
      InputTransferDTO inputTransferDTO
  ) {
    return new AccountDTO(
        accountEntity.getName(),
        accountEntity.getId(),
        calculateBalance(accountEntity.getAccountTransfers()),
        calculateBalanceP(accountEntity, inputTransferDTO),
        TransferDTO.fromEntityPage(transferEntities)
    );
  }


  public static List<AccountDTO> fromEntityList(
      Iterable<AccountEntity> accountEntityList,
      InputTransferDTO inputTransferDTO
  ) {
    List<AccountDTO> accountDTOList = new ArrayList<>();

    for (AccountEntity accountEntity : accountEntityList) {
      accountDTOList.add(fromEntity(accountEntity, inputTransferDTO));
    }
    return accountDTOList;
  }

  private static float calculateBalanceP(AccountEntity accountEntity,
      InputTransferDTO inputTransferDTO) {
    float balance = 0;

    if (inputTransferDTO == null) {
      return calculateBalance(accountEntity.getAccountTransfers());
    }

    if (inputTransferDTO.isValidOperatorName()) {
      return balanceByName(accountEntity, inputTransferDTO);
    } else if (inputTransferDTO.isValidDate()) {
      return balanceByDate(accountEntity, inputTransferDTO);
    } else {
      return calculateBalance(accountEntity.getAccountTransfers());
    }
  }

  private static float balanceByName(AccountEntity accountEntity,
      InputTransferDTO inputTransferDTO) {
    float balance = 0;

    for (TransferEntity transferEntity : accountEntity.getAccountTransfers()) {
      Optional<String> operatorName = Optional.ofNullable(transferEntity.getOperatorName());

      if (operatorName.isPresent() && operatorName.get()
          .equals(inputTransferDTO.getOperatorName())) {
        balance += transferEntity.getValue();
      }
    }
    return balance;
  }

  private static float balanceByDate(AccountEntity accountEntity,
      InputTransferDTO inputTransferDTO) {
    float balance = 0;

    for (TransferEntity transferEntity : accountEntity.getAccountTransfers()) {
      if (transferEntity.getTransferDate().isAfter(inputTransferDTO.getInitialDate())
          && transferEntity.getTransferDate().isBefore(inputTransferDTO.getFinalDate())) {
        balance += transferEntity.getValue();
      }
    }
    return balance;
  }

  private static float calculateBalance(List<TransferEntity> transferDTOList) {
    float balance = 0;
    for (TransferEntity transferEntity : transferDTOList) {
      balance += transferEntity.getValue();
    }
    return balance;
  }

}
