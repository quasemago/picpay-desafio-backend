package dev.quasemago.desafio_picpay.infra.notification.exception;

public class PicPayNotificationException extends RuntimeException {
    public PicPayNotificationException(String message) {
        super(message);
    }
}
