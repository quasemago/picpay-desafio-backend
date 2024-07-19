package dev.quasemago.desafio_picpay.domain.wallet.service.factory;

import dev.quasemago.desafio_picpay.domain.wallet.exception.PicPayInvalidWalletException;
import dev.quasemago.desafio_picpay.domain.wallet.model.Wallet;

import java.math.BigDecimal;

public class UserWalletFactory implements WalletFactory {
    @Override
    public Wallet createWallet(String name, String registry, String email, String password, BigDecimal balance) {
        Wallet wallet = new Wallet(name, registry, email, password, balance, Wallet.WalletType.USER);
        if (wallet.isRegistryValid()) {
            return wallet;
        }
        throw new PicPayInvalidWalletException("Invalid registry for user wallet");
    }
}
