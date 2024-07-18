package dev.quasemago.desafio_picpay.domain.transaction.exception;

public class PicPayTransactionException extends RuntimeException {
    public PicPayTransactionException(String message) {
        super(message);
    }
}
