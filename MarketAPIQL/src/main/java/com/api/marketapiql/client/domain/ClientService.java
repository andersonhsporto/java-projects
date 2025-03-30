package com.api.marketapiql.client.domain;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(tempFactory());
    }

    private Client tempFactory() {
        return new Client(1L, "Frodo Baggins", "test", "test", null);
    }

    public Collection<Client> findAllByProductId(Long id) {
        return clientRepository.findAllByProductsId(id);
    }

    public Client createClient(ClientInputDTO clientInputDTO) {
        return clientRepository.save(clientInputDTO.toClient());
    }
}

