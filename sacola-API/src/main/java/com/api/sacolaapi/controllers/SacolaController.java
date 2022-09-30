package com.api.sacolaapi.controllers;

import com.api.sacolaapi.dto.ItemDto;
import com.api.sacolaapi.models.Sacola;
import com.api.sacolaapi.services.SacolaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sacolas")
@RequiredArgsConstructor
public class SacolaController {

  private final SacolaService sacolaService;

  @PostMapping
  public ResponseEntity<?> incluirItemNaSacola(@RequestBody ItemDto itemDto) {
    return sacolaService.incluirItemNaSacola(itemDto);
  }

  @GetMapping("/{id}")
  public Sacola verSacola(@PathVariable("id") Long id) {
    return sacolaService.verSacola(id);
  }

  @PatchMapping("/fecharSacola/{sacolaId}")
  public Sacola fecharSacola(@PathVariable("sacolaId") Long sacolaId,
      @RequestParam("formaPagamento") int formaPagamento) {
    return sacolaService.fecharSacola(sacolaId, formaPagamento);
  }
}