package br.com.banco.service;

import br.com.banco.DTO.InputTransferDTO;
import br.com.banco.DTO.TransferDTO;
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

  public ResponseEntity<?> getByTransferId() {
    Optional<TransferEntity> entity = transferRepository.findById(1L);

    if (entity.isPresent()) {
      return ResponseEntity.ok(TransferDTO.fromEntity(entity.get()));
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  public ResponseEntity<?> getTransferBetweenTwoDates(InputTransferDTO inputTransferDTO) {
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

  public ResponseEntity<?> getTransferByOperatorName(InputTransferDTO inputTransferDTO) {
    String operatorName = inputTransferDTO.getOperatorName();
    List<TransferEntity> entity = transferRepository.findByOperatorName(operatorName);

    if (entity.isEmpty()) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(TransferDTO.fromEntityList(entity));
    }
  }

}
