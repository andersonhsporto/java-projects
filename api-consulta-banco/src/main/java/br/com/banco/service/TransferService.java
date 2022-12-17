package br.com.banco.service;

import br.com.banco.domain.DTO.InputTransferDTO;
import br.com.banco.domain.DTO.TransferDTO;
import br.com.banco.domain.TransferEntity;
import br.com.banco.repository.TransferRepository;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferService {

  private final TransferRepository transferRepository;

  public ResponseEntity<?> getByTransferId(InputTransferDTO inputTransferDTO) {
    try {
      return persistById(inputTransferDTO);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  public ResponseEntity<?> getTransferBetweenTwoDates(InputTransferDTO inputTransferDTO) {
    try {
      return persistBetweenTwoDates(inputTransferDTO);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  public ResponseEntity<?> getTransferByOperatorName(InputTransferDTO inputTransferDTO) {
    try {
      return persistByOperatorName(inputTransferDTO);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  private ResponseEntity<?> persistById(InputTransferDTO inputTransferDTO) throws Exception {
    Optional<TransferEntity> transferEntity = transferRepository.findById(
        inputTransferDTO.getTransferId());

    if (transferEntity.isPresent()) {
      return ResponseEntity.ok(TransferDTO.fromEntity(transferEntity.get()));
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  private ResponseEntity<?> persistBetweenTwoDates(InputTransferDTO inputTransferDTO)
      throws Exception {
    OffsetDateTime initialDate = inputTransferDTO.getInitialDate();
    OffsetDateTime finalDate = inputTransferDTO.getFinalDate();
    List<TransferEntity> entity = transferRepository.findByTransferDateBetween(initialDate,
        finalDate);

    if (entity.isEmpty()) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(TransferDTO.fromEntityList(entity));
    }
  }

  private ResponseEntity<?> persistByOperatorName(InputTransferDTO inputTransferDTO)
      throws Exception {
    String operatorName = inputTransferDTO.getOperatorName();
    if (operatorName.isEmpty()) {
      throw new Exception("Operator name is empty");
    }

    List<TransferEntity> entity = transferRepository.findByOperatorName(operatorName);

    if (entity.isEmpty()) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(TransferDTO.fromEntityList(entity));
    }
  }

}
