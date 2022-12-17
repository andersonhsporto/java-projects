package br.com.banco.service;

import br.com.banco.DTO.TransferDTO;
import br.com.banco.domain.TransferEntity;
import br.com.banco.repository.TransferRepository;
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

}
