package dev.quasemago.desafio_picpay.web.dto;

import dev.quasemago.desafio_picpay.domain.wallet.model.Wallet;

import java.math.BigDecimal;

public record WalletResponseDTO(Long id,
                                String name,
                                String registry,
                                String email,
                                BigDecimal balance,
                                String type) {
    public static WalletResponseDTO from(Wallet wallet) {
        return new WalletResponseDTO(wallet.getId(),
                wallet.getName(),
                wallet.getRegistry(),
                wallet.getEmail(),
                wallet.getBalance(),
                wallet.getType().name());
    }
}
