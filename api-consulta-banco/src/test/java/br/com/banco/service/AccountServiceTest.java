package br.com.banco.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import br.com.banco.domain.DTO.AccountDTO;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(properties = "spring.main.banner-mode=off")
@AutoConfigureDataJpa
@AutoConfigureTestDatabase
class AccountServiceTest {

  @Autowired
  private AccountService accountService;

  @Test
  @DisplayName("Test if getAllAccount return status 200")
  void getAllAccount_should_return_status_200_OK() {
    ResponseEntity<?> response = accountService.getAllAccount();

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

  @Test
  @DisplayName("Test if getAllAccount return a list of accounts")
  void getAllAccount_should_return_a_list_of_accounts() {
    ResponseEntity<?> response = accountService.getAllAccount();

    assertThat(response.getBody()).isInstanceOf(List.class);
  }

  @Test
  @DisplayName("Test if getAccountById return status 200")
  void getAccountById_should_return_status_200_OK() {
    ResponseEntity<?> response = accountService.getAccountById(1L);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

  @Test
  @DisplayName("Test if getAccountById return a account")
  void getAccountById_should_return_a_account() {
    ResponseEntity<?> response = accountService.getAccountById(1L);

    assertThat(response.getBody()).isInstanceOf(AccountDTO.class);
  }

  @Test
  @DisplayName("Test if getAccountById return status 400")
  void getAccountById_should_return_status_400_BAD_REQUEST() {
    ResponseEntity<?> response = accountService.getAccountById(100L);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
  }

}