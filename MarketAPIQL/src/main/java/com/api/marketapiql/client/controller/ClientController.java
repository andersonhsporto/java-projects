package com.api.marketapiql.client.controller;

import com.api.marketapiql.client.domain.Client;
import com.api.marketapiql.client.domain.ClientInputDTO;
import com.api.marketapiql.client.domain.ClientService;
import com.api.marketapiql.client.domain.Product;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
@AllArgsConstructor
@Log4j2
public class ClientController {

    private final ClientService clientService;

    @QueryMapping
    public Client clientById(@Argument Long id) {
        log.info("Finding client by id: {}", id);
        return clientService.findById(id);
    }

    @SchemaMapping
    public Collection<Client> clients(Product product) {
        log.info("Finding clients for product: {}", product);
        return clientService.findAllByProductId(product.getId());
    }

    @MutationMapping
    public Client createClient(@Argument(name = "client") ClientInputDTO clientInputDTO) {
        log.info("Creating client: {}", clientInputDTO);
        return clientService.createClient(clientInputDTO);
    }

}
