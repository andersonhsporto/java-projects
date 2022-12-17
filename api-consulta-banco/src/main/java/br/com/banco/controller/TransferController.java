package br.com.banco.controller;

import br.com.banco.domain.DTO.InputTransferDTO;
import br.com.banco.service.TransferService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/v1/transfers")
public class TransferController {

  private final TransferService transferService;

  @ApiOperation(value = "Return a list of all transfers using a given id")
  @GetMapping
  public ResponseEntity<?> getByTransferId(@RequestBody InputTransferDTO inputTransferDTO) {
    return transferService.getByTransferId(inputTransferDTO);
  }

  @ApiOperation(value = "Get all transfer between two dates")
  @GetMapping("/between-dates")
  public ResponseEntity<?> getTransferBetweenTwoDates(
      @RequestBody InputTransferDTO inputTransferDTO) {
    return transferService.getTransferBetweenTwoDates(inputTransferDTO);
  }

  @ApiOperation(value = "Get all transfer related to a given account name")
  @GetMapping("/operator-name")
  public ResponseEntity<?> getTransferByOperatorName(
      @RequestBody InputTransferDTO inputTransferDTO) {
    return transferService.getTransferByOperatorName(inputTransferDTO);
  }


}
