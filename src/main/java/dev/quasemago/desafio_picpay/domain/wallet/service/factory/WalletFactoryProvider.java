package dev.quasemago.desafio_picpay.domain.wallet.service.factory;

import dev.quasemago.desafio_picpay.domain.wallet.exception.PicPayInvalidWalletException;
import dev.quasemago.desafio_picpay.domain.wallet.model.Wallet;

public class WalletFactoryProvider {
    public static WalletFactory getFactory(String type) {
        try {
            final var walletType = Wallet.WalletType.valueOf(type);
            return switch (walletType) {
                case USER -> new UserWalletFactory();
                case SELLER -> new SellerWalletFactory();
            };
        } catch (IllegalArgumentException ex) {
             throw new PicPayInvalidWalletException("Invalid wallet type!");
        }
    }
}
