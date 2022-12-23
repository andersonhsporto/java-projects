package br.com.banco.controller;

import br.com.banco.domain.DTO.InputTransferDTO;
import br.com.banco.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/v1/accounts")
public class AccountController {

  private final AccountService accountService;

  @GetMapping("/number")
  public ResponseEntity<?> getAccountById(
      @RequestParam(required = true) Long id,
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "4") Integer size
  ) {
    return accountService.getAccountById(id, page, size);
  }

  @GetMapping("/date")
  public ResponseEntity<?> getAccountByDate(
      @RequestParam(required = true) Long id,
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "4") Integer size,
      @RequestBody InputTransferDTO inputTransferDTO
  ) {
    return accountService.getAccountByDate(id, page, size, inputTransferDTO);
  }

  @GetMapping("/name")
  public ResponseEntity<?> getAccountByName(
      @RequestParam(required = true) Long id,
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "4") Integer size,
      @RequestBody InputTransferDTO inputTransferDTO
  ) {
    return accountService.getAccountByName(id, page, size, inputTransferDTO);
  }


}
