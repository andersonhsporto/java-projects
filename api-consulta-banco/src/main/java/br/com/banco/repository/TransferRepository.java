package br.com.banco.repository;

import br.com.banco.domain.TransferEntity;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<TransferEntity, Long> {

  List<TransferEntity> findByTransferDateBetween(OffsetDateTime initialDate,
      OffsetDateTime finalDate);

  List<TransferEntity> findByOperatorName(String operatorName);

}