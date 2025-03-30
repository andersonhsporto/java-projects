package com.api.sacolaapi.services;

import com.api.sacolaapi.dto.ItemDto;
import com.api.sacolaapi.models.Sacola;
import org.springframework.http.ResponseEntity;

public interface SacolaService {

  ResponseEntity<?> incluirItemNaSacola(ItemDto itemDto);

  Sacola verSacola(Long id);

  Sacola fecharSacola(Long id, int formaPagamento);

  ResponseEntity<?> deleteSacola(Long id);

  ResponseEntity<?> alterarItemNaSacola(Long id, ItemDto itemDto);
}
