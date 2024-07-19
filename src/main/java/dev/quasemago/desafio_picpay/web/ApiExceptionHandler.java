package dev.quasemago.desafio_picpay.web;

import dev.quasemago.desafio_picpay.domain.transaction.exception.PicPayTransactionException;
import dev.quasemago.desafio_picpay.domain.wallet.exception.PicPayInvalidWalletException;
import dev.quasemago.desafio_picpay.domain.wallet.exception.PicPayWalletNotFoundException;
import dev.quasemago.desafio_picpay.infra.authorization.exception.PicPayAuthorizationException;
import dev.quasemago.desafio_picpay.infra.notification.exception.PicPayNotificationException;
import dev.quasemago.desafio_picpay.web.dto.ErrorMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessageDTO> handleMethodArgumentNotValidException(BindingResult result) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessageDTO(HttpStatus.BAD_REQUEST, "Invalid field(s)", result));
    }

    @ExceptionHandler({
            PicPayAuthorizationException.class,
            PicPayNotificationException.class,
            PicPayTransactionException.class,
            PicPayInvalidWalletException.class
    })
    public ResponseEntity<ErrorMessageDTO> handlePicPayGeneralException(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessageDTO(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(PicPayWalletNotFoundException.class)
    public ResponseEntity<ErrorMessageDTO> handlePicPayWalletNotFound(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessageDTO(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessageDTO> handleGenericException() {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessageDTO(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Error."));
    }
}
