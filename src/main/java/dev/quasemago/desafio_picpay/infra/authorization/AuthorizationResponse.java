package dev.quasemago.desafio_picpay.infra.authorization;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthorizationResponse(String status,
                                    Data data) {
    record Data(@JsonProperty("authorization") Boolean authorization) {
    }
}
