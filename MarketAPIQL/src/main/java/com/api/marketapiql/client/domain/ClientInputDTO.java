package com.api.marketapiql.client.domain;

public record ClientInputDTO(String name, String email, String phone) {

    public Client toClient() {
        return new Client(null, name(), email(), phone(), null);
    }
}
