package br.com.banco.repository;

import br.com.banco.domain.AccountEntity;
import br.com.banco.domain.TransferEntity;
import java.time.OffsetDateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends PagingAndSortingRepository<TransferEntity, Long> {

  Page<TransferEntity> findAllByConta(AccountEntity conta, Pageable pageable);

  Page<TransferEntity> findAllByContaAndTransferDateBetween(
      AccountEntity conta, Pageable pageable, OffsetDateTime initialDate,
      OffsetDateTime finalDate
  );

  Page<TransferEntity> findAllByContaAndOperatorName(
      AccountEntity conta, Pageable pageable, String transferName);

  Page<TransferEntity> findAllByContaAndOperatorNameAndTransferDateBetween(
      AccountEntity conta, Pageable pageable, String transferName,
      OffsetDateTime initialDate, OffsetDateTime finalDate
  );
}