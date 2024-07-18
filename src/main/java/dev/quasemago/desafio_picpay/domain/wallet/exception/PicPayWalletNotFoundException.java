package dev.quasemago.desafio_picpay.domain.wallet.exception;

public class PicPayWalletNotFoundException extends RuntimeException {
    public PicPayWalletNotFoundException(String message) {
        super(message);
    }
}
