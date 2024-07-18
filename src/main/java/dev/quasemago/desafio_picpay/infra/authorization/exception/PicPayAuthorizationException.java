package dev.quasemago.desafio_picpay.infra.authorization.exception;

public class PicPayAuthorizationException extends RuntimeException {
    public PicPayAuthorizationException(String message) {
        super(message);
    }
}
