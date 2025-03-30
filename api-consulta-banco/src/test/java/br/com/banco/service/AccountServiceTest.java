package br.com.banco.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import br.com.banco.domain.DTO.InputTransferDTO;
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
  @DisplayName("Test if getAccountBy returns status 200")
  void getAccountBy() {
    ResponseEntity<?> response = accountService.getAccountById(
        InputTransferDTO.of(
            1L,
            0,
            4,
            "1990-12-20T00:00:00Z",
            "1990-12-20T00:00:00Z",
            "null")
    );

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
  }


}