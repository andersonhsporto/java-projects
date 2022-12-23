package br.com.banco.service;

import br.com.banco.domain.AccountEntity;
import br.com.banco.domain.DTO.AccountDTO;
import br.com.banco.domain.DTO.InputTransferDTO;
import br.com.banco.domain.TransferEntity;
import br.com.banco.repository.AccountRepository;
import br.com.banco.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {

  private final AccountRepository accountRepository;

  private final TransferRepository transferRepository;

  @Transactional
  public ResponseEntity<?> getAccountById(Long id, Integer page, Integer size) {
    try {

      return findAccountById(id, page, size);

    } catch (Exception e) {

      return ResponseEntity.badRequest().body("Conta não encontrada" + e.getMessage());

    }
  }

  @Transactional
  public ResponseEntity<?> getAccountByDate(
      Long id,
      Integer page,
      Integer size,
      InputTransferDTO inputTransferDTO
  ) {
    try {

      return findAccountByDate(id, page, size, inputTransferDTO);

    } catch (Exception e) {

      return ResponseEntity.badRequest().body("Conta não encontrada");

    }
  }

  @Transactional
  public ResponseEntity<?> getAccountByName(
      Long id,
      Integer page,
      Integer size,
      InputTransferDTO inputTransferDTO
  ) {
    try {

      return findAccountByName(id, page, size, inputTransferDTO);

    } catch (Exception e) {

      return ResponseEntity.badRequest().body("Conta não encontrada" + e.getMessage());

    }
  }


  private ResponseEntity<?> findAccountById(Long id, Integer page, Integer size) {

    Pageable pageRequest = PageRequest.of(page, size);
    AccountEntity accountEntity = accountRepository.findById(id).orElseThrow();
    Page<TransferEntity> transferEntities = transferRepository.findAllByConta(
        accountEntity, pageRequest);
    HttpHeaders headers = getHeaders(transferEntities);

    return new ResponseEntity<>(
        AccountDTO.fromEntityAndPage(accountEntity, transferEntities, null),
        headers,
        HttpStatus.OK);
  }

  private ResponseEntity<?> findAccountByDate(
      Long id,
      Integer page,
      Integer size,
      InputTransferDTO inputTransferDTO) {

    Pageable pageRequest = PageRequest.of(page, size);
    AccountEntity accountEntity = accountRepository.findById(id).orElseThrow();
    Page<TransferEntity> transferEntities = transferRepository.findAllByContaAndTransferDateBetween(
        accountEntity,
        pageRequest,
        inputTransferDTO.getInitialDate(),
        inputTransferDTO.getFinalDate());
    HttpHeaders headers = getHeaders(transferEntities);

    return new ResponseEntity<>(
        AccountDTO.fromEntityAndPage(accountEntity, transferEntities, inputTransferDTO),
        headers,
        HttpStatus.OK);
  }

  private ResponseEntity<?> findAccountByName(
      Long id,
      Integer page,
      Integer size,
      InputTransferDTO inputTransferDTO) {

    Pageable pageRequest = PageRequest.of(page, size);
    AccountEntity accountEntity = accountRepository.findById(id).orElseThrow();
    Page<TransferEntity> transferEntities = transferRepository.findAllByContaAndOperatorName(
        accountEntity,
        pageRequest,
        inputTransferDTO.getOperatorName());
    HttpHeaders headers = getHeaders(transferEntities);

    return new ResponseEntity<>(
        AccountDTO.fromEntityAndPage(accountEntity, transferEntities, inputTransferDTO),
        headers,
        HttpStatus.OK);
  }

  private HttpHeaders getHeaders(Page<TransferEntity> transferEntities) {
    HttpHeaders headers = new HttpHeaders();

    headers.add("Access-Control-Expose-Headers", "X-Total-Count");
    headers.add("x-total-count", String.valueOf(transferEntities.getTotalElements()));
    return headers;
  }

}
