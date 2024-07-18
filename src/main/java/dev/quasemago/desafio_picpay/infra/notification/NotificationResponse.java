package dev.quasemago.desafio_picpay.infra.notification;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NotificationResponse(String status,
                                   @JsonProperty("data.authorization") Boolean notification) {
}
