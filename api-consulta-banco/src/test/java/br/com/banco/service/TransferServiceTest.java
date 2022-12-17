package br.com.banco.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import br.com.banco.domain.DTO.InputTransferDTO;
import br.com.banco.domain.DTO.TransferDTO;
import java.time.OffsetDateTime;
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
class TransferServiceTest {

  @Autowired
  private TransferService transferService;

  @Test
  @DisplayName("Test if getByTransferId return status 200")
  void getByTransferId_should_return_status_200_OK() {
    InputTransferDTO temporaryTransferDTO = new InputTransferDTO();
    temporaryTransferDTO.setTransferId(1L);
    ResponseEntity<?> response = transferService.getByTransferId(temporaryTransferDTO);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

  @Test
  @DisplayName("Test if getTransferId return DTO")
  void getByTransferId_should_return_DTO() {
    InputTransferDTO temporaryTransferDTO = new InputTransferDTO();
    temporaryTransferDTO.setTransferId(1L);
    ResponseEntity<?> response = transferService.getByTransferId(temporaryTransferDTO);

    assertThat(response.getBody()).isInstanceOf(TransferDTO.class);
  }

  @Test
  @DisplayName("Test if getByTransferId return status 404 not found")
  void getByTransferId_should_return_status_404_not_found() {
    InputTransferDTO temporaryTransferDTO = new InputTransferDTO();
    temporaryTransferDTO.setTransferId(100L);
    ResponseEntity<?> response = transferService.getByTransferId(temporaryTransferDTO);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
  }

  @Test
  @DisplayName("Test if getByTransferId return status 400 bad request")
  void getByTransferId_should_return_status_400_bad_request() {
    InputTransferDTO temporaryTransferDTO = new InputTransferDTO();
    ResponseEntity<?> response = transferService.getByTransferId(temporaryTransferDTO);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
  }

  @Test
  @DisplayName("Test if getTransferBetweenTwoDates return status 200")
  void getTransferBetweenTwoDates_should_return_status_200_OK() {
    InputTransferDTO temporaryTransferDTO = new InputTransferDTO();
    OffsetDateTime initialDate = OffsetDateTime.parse("2021-01-01T00:00:00Z");
    OffsetDateTime finalDate = OffsetDateTime.parse("2024-01-31T00:00:00Z");
    temporaryTransferDTO.setInitialDate(initialDate);
    temporaryTransferDTO.setFinalDate(finalDate);

    ResponseEntity<?> response = transferService.getTransferBetweenTwoDates(temporaryTransferDTO);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

  @Test
  @DisplayName("Test if getTransferBetweenTwoDates return status 400 bad request")
  void getTransferBetweenTwoDates_should_return_status_400_bad_request() {
    InputTransferDTO temporaryTransferDTO = new InputTransferDTO();
    ResponseEntity<?> response = transferService.getTransferBetweenTwoDates(temporaryTransferDTO);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
  }

  @Test
  @DisplayName("Test if getTransferBetweenTwoDates return status 404 not found")
  void getTransferBetweenTwoDates_should_return_status_404_not_found() {
    InputTransferDTO temporaryTransferDTO = new InputTransferDTO();
    OffsetDateTime initialDate = OffsetDateTime.parse("2042-01-01T00:00:00Z");
    OffsetDateTime finalDate = OffsetDateTime.parse("2042-01-31T00:00:00Z");
    temporaryTransferDTO.setInitialDate(initialDate);
    temporaryTransferDTO.setFinalDate(finalDate);

    ResponseEntity<?> response = transferService.getTransferBetweenTwoDates(temporaryTransferDTO);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
  }

  @Test
  @DisplayName("Test if getTransferBetweenTwoDates return a List")
  void getTransferBetweenTwoDates_should_return_List_of_DTO() {
    InputTransferDTO temporaryTransferDTO = new InputTransferDTO();
    OffsetDateTime initialDate = OffsetDateTime.parse("2021-01-01T00:00:00Z");
    OffsetDateTime finalDate = OffsetDateTime.parse("2024-01-31T00:00:00Z");
    temporaryTransferDTO.setInitialDate(initialDate);
    temporaryTransferDTO.setFinalDate(finalDate);

    ResponseEntity<?> response = transferService.getTransferBetweenTwoDates(temporaryTransferDTO);

    assertThat(response.getBody()).isInstanceOf(List.class);
  }

  @Test
  @DisplayName("Test if getTransferByOperatorName return status 200")
  void getTransferByOperatorName_should_return_status_200_OK() {
    InputTransferDTO temporaryTransferDTO = new InputTransferDTO();
    temporaryTransferDTO.setOperatorName("Beltrano");
    ResponseEntity<?> response = transferService.getTransferByOperatorName(temporaryTransferDTO);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

  @Test
  @DisplayName("Test if getTransferByOperatorName return status 400 bad request")
  void getTransferByOperatorName_should_return_status_400_bad_request() {
    InputTransferDTO temporaryTransferDTO = new InputTransferDTO();
    System.out.println("AQUI\t" + temporaryTransferDTO.getOperatorName());
    ResponseEntity<?> response = transferService.getTransferByOperatorName(temporaryTransferDTO);

    System.out.println(response.getBody());

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
  }

  @Test
  @DisplayName("Test if getTransferByOperatorName return status 404 not found")
  void getTransferByOperatorName_should_return_status_404_not_found() {
    InputTransferDTO temporaryTransferDTO = new InputTransferDTO();
    temporaryTransferDTO.setOperatorName("Fulano");
    ResponseEntity<?> response = transferService.getTransferByOperatorName(temporaryTransferDTO);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
  }

  @Test
  @DisplayName("Test if getTransferByOperatorName return a List")
  void getTransferByOperatorName_should_return_List_of_DTO() {
    InputTransferDTO temporaryTransferDTO = new InputTransferDTO();
    temporaryTransferDTO.setOperatorName("Beltrano");
    ResponseEntity<?> response = transferService.getTransferByOperatorName(temporaryTransferDTO);

    assertThat(response.getBody()).isInstanceOf(List.class);
  }

}