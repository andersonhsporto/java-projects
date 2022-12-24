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

  public ResponseEntity<?> getAccount(InputTransferDTO inputTransferDTO) {

    if (inputTransferDTO.isValidNameAndDate()) {
      return getAccountByDateAndName(inputTransferDTO);
    } else if (inputTransferDTO.isValidDate()) {
      return getAccountByDate(inputTransferDTO);
    } else if (inputTransferDTO.isValidOperatorName()) {
      return getAccountByName(inputTransferDTO);
    } else {
      System.out.println("getAccountById");
      return getAccountById(inputTransferDTO);
    }
  }

  @Transactional
  public ResponseEntity<?> getAccountById(InputTransferDTO inputTransferDTO) {
    try {

      return findAccountById(inputTransferDTO);

    } catch (Exception e) {

      return ResponseEntity.badRequest().body("Conta não encontrada" + e.getMessage());

    }
  }

  @Transactional
  public ResponseEntity<?> getAccountByDate(InputTransferDTO inputTransferDTO) {
    try {

      return findAccountByDate(inputTransferDTO);

    } catch (Exception e) {

      return ResponseEntity.badRequest().body("Conta não encontrada");

    }
  }

  @Transactional
  public ResponseEntity<?> getAccountByName(InputTransferDTO inputTransferDTO) {
    try {

      return findAccountByName(inputTransferDTO);

    } catch (Exception e) {

      return ResponseEntity.badRequest().body("Conta não encontrada" + e.getMessage());

    }
  }

  @Transactional
  public ResponseEntity<?> getAccountByDateAndName(InputTransferDTO inputTransferDTO) {
    try {

      return findAccountByDateAndName(inputTransferDTO);

    } catch (Exception e) {

      return ResponseEntity.badRequest().body("Conta não encontrada" + e.getMessage());

    }
  }

  private ResponseEntity<?> findAccountById(InputTransferDTO inputTransferDTO) {

    Pageable pageRequest = PageRequest.of(inputTransferDTO.getPage(), inputTransferDTO.getSize());
    AccountEntity accountEntity = accountRepository.findById(inputTransferDTO.getId())
        .orElseThrow();
    Page<TransferEntity> transferEntities = transferRepository.findAllByConta(
        accountEntity, pageRequest);
    HttpHeaders headers = getHeaders(transferEntities);

    return new ResponseEntity<>(
        AccountDTO.fromEntityAndPage(accountEntity, transferEntities, null),
        headers,
        HttpStatus.OK);
  }

  private ResponseEntity<?> findAccountByDate(InputTransferDTO inputTransferDTO) {

    Pageable pageRequest = PageRequest.of(inputTransferDTO.getPage(), inputTransferDTO.getSize());
    AccountEntity accountEntity = accountRepository.findById(inputTransferDTO.getId())
        .orElseThrow();
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

  private ResponseEntity<?> findAccountByName(InputTransferDTO inputTransferDTO) {

    Pageable pageRequest = PageRequest.of(inputTransferDTO.getPage(), inputTransferDTO.getSize());
    AccountEntity accountEntity = accountRepository.findById(inputTransferDTO.getId())
        .orElseThrow();
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

  private ResponseEntity<?> findAccountByDateAndName(InputTransferDTO inputTransferDTO) {

    Pageable pageRequest = PageRequest.of(inputTransferDTO.getPage(), inputTransferDTO.getSize());
    AccountEntity accountEntity = accountRepository.findById(inputTransferDTO.getId())
        .orElseThrow();
    Page<TransferEntity> transferEntities = getPageTransferEntities(
        accountEntity,
        pageRequest,
        inputTransferDTO);
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

  private Page<TransferEntity> getPageTransferEntities(
      AccountEntity accountEntity,
      Pageable pageRequest,
      InputTransferDTO inputTransferDTO
  ) {
    return transferRepository.findAllByContaAndOperatorNameAndTransferDateBetween(
        accountEntity,
        pageRequest,
        inputTransferDTO.getOperatorName(),
        inputTransferDTO.getInitialDate(),
        inputTransferDTO.getFinalDate());
  }
}
