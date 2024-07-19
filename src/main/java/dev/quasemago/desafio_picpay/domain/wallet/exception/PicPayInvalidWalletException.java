package dev.quasemago.desafio_picpay.domain.wallet.exception;

public class PicPayInvalidWalletException extends RuntimeException {
    public PicPayInvalidWalletException(String message) {
        super(message);
    }
}
