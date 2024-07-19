package dev.quasemago.desafio_picpay.domain.wallet.service.validation;

import dev.quasemago.desafio_picpay.domain.wallet.model.Wallet;

public class WalletRegistryValidationFactory {
    public static WalletRegistryValidation getStrategy(Wallet.WalletType type) {
        return switch (type) {
            case USER -> new UserWalletRegistryValidation();
            case SELLER -> new SellerWalletRegistryValidation();
        };
    }
}
