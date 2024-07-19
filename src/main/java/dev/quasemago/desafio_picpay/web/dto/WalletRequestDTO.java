package dev.quasemago.desafio_picpay.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

public record WalletRequestDTO(@NotBlank String name,
                               @NotBlank String registry,
                               @Email String email,
                               @NotBlank String password,
                               @NotNull BigDecimal balance,
                               String type) {
}
