package dev.quasemago.desafio_picpay.infra.notification;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NotificationResponse(String status,
                                   Data data) {
    record Data(@JsonProperty("authorization") Boolean authorization) {
    }
}
