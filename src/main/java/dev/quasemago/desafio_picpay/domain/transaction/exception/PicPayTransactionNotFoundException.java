package dev.quasemago.desafio_picpay.domain.transaction.exception;

public class PicPayTransactionNotFoundException extends RuntimeException {
    public PicPayTransactionNotFoundException(String message) {
        super(message);
    }
}
