package br.com.banco.controller;

import br.com.banco.domain.DTO.InputTransferDTO;
import br.com.banco.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/v1/accounts")
public class AccountController {

  private final AccountService accountService;

  @GetMapping
  public ResponseEntity<?> getAccount(
      @RequestParam(value = "id", required = true) Long id,
      @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = false, defaultValue = "4") Integer size,
      @RequestParam(value = "initialDate", required = false, defaultValue = "1990-12-20T00:00:00Z") String initialDate,
      @RequestParam(value = "finalDate", required = false, defaultValue = "1990-12-20T00:00:00Z") String finalDate,
      @RequestParam(value = "operatorName", required = false, defaultValue = "null") String operatorName
  ) {
    try {
      return accountService.getAccount(
          InputTransferDTO.of(
              id,
              page,
              size,
              initialDate,
              finalDate,
              operatorName)
      );
    } catch (Exception e) {
      return ResponseEntity.internalServerError().build();
    }
  }

}
