package dev.quasemago.desafio_picpay.infra.authorization;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthorizationResponse(String status,
                                    @JsonProperty("data.authorization") Boolean authorization) {
}
