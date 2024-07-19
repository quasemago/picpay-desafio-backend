package dev.quasemago.desafio_picpay.domain.wallet.service.factory;

import dev.quasemago.desafio_picpay.domain.wallet.model.Wallet;

import java.math.BigDecimal;

public interface WalletFactory {
    Wallet createWallet(String name, String registry, String email, String password, BigDecimal balance);
}
