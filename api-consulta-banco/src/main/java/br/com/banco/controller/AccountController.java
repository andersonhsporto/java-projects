package br.com.banco.controller;

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
  public ResponseEntity<?> getAllAccounts() {
    return accountService.getAllAccount();
  }

  @GetMapping("/number")
  public ResponseEntity<?> getAccountById(@RequestParam(required = true) Long id) {
    return accountService.getAccountById(id);
  }


}
