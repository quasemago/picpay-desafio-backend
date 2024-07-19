package dev.quasemago.desafio_picpay.domain.wallet.service.validation;

public class UserWalletRegistryValidation implements WalletRegistryValidation {
    @Override
    public boolean validate(String registry) {
        return registry != null && registry.length() == 11;
    }
}
