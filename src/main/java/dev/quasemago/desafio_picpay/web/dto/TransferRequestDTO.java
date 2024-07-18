package dev.quasemago.desafio_picpay.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record TransferRequestDTO(
        @NotNull @Positive BigDecimal value,
        @NotNull Long payer,
        @NotNull Long payee) {
}
