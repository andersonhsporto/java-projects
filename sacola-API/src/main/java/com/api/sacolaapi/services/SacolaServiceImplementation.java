package com.api.sacolaapi.services;

import com.api.sacolaapi.dto.ItemDto;
import com.api.sacolaapi.enums.FormaPagamento;
import com.api.sacolaapi.models.Item;
import com.api.sacolaapi.models.Sacola;
import com.api.sacolaapi.repositories.ProdutoRepository;
import com.api.sacolaapi.repositories.SacolaRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SacolaServiceImplementation implements SacolaService {

  private final SacolaRepository sacolaRepository;
  private final ProdutoRepository produtoRepository;

  @Override
  public ResponseEntity<?> incluirItemNaSacola(ItemDto itemDto) {
    var sacola = verSacola(itemDto.getSacolaId());

    if (sacola.isFechada()) {
      return new ResponseEntity<>("Esta sacola está fechada.", HttpStatus.CONFLICT);
    }

    var itemParaSerInserido = Item.builder()
        .quantidade(itemDto.getQuantidade())
        .sacola(sacola)
        .produto(produtoRepository.findById(itemDto.getProdutoId()).orElseThrow(
            () -> {
              throw new RuntimeException("Esse produto não existe!");
            }
        ))
        .build();

    var itensDaScola = sacola.getItens();
    if (itensDaScola.isEmpty()) {
      itensDaScola.add(itemParaSerInserido);
    } else {
      var restauranteAtual = itensDaScola.get(0).getProduto().getRestaurante();
      var restauranteDoItemParaAdicionar = itemParaSerInserido.getProduto()
          .getRestaurante();
      if (restauranteAtual.equals(restauranteDoItemParaAdicionar)) {
        itensDaScola.add(itemParaSerInserido);
      } else {
        throw new RuntimeException(
            "Não é possível adicionar produtos de "
                + "restaurantes diferentes. Feche a sacola ou esvazie.");
      }
    }

    List<Double> valorDosItens = new ArrayList<>();
    for (Item itemDaSacola : itensDaScola) {
      var valorTotalItem =
          itemDaSacola.getProduto().getValorUnitario() * itemDaSacola.getQuantidade();
      valorDosItens.add(valorTotalItem);
    }

    double valorTotalSacola = valorDosItens.stream()
        .mapToDouble(valorTotalDeCadaItem -> valorTotalDeCadaItem)
        .sum();

    sacola.setValorTotal(valorTotalSacola);
    sacolaRepository.save(sacola);
    return new ResponseEntity<>(itemParaSerInserido, HttpStatus.OK);
  }


  @Override
  public Sacola verSacola(Long id) {
    return sacolaRepository.findById(id).orElseThrow(
        () -> {
          throw new RuntimeException("Essa sacola não existe!");
        }
    );
  }

  @Override
  public Sacola fecharSacola(Long id, int numeroformaPagamento) {
    var sacola = verSacola(id);

    if (sacola.getItens().isEmpty()) {
      throw new RuntimeException("Inclua ítens na sacola!");
    }
    var formaPagamento =
        numeroformaPagamento == 0 ? FormaPagamento.DINHEIRO : FormaPagamento.MAQUINA;

    sacola.setFormaPagamento(formaPagamento);
    sacola.setFechada(true);
    return sacolaRepository.save(sacola);
  }
}
