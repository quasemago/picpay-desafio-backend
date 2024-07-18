package dev.quasemago.desafio_picpay.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public record ErrorMessageDTO(int code,
                              String status,
                              String message,
                              @JsonInclude(JsonInclude.Include.NON_EMPTY) List<FieldErrorDetails> details) {
    public ErrorMessageDTO(HttpStatus status, String message) {
        this(status.value(), status.getReasonPhrase(), message, new ArrayList<>());
    }

    public ErrorMessageDTO(HttpStatus status, String message, BindingResult result) {
        this(status.value(), status.getReasonPhrase(), message, new ArrayList<>());
        addDetails(result);
    }

    private void addDetails(BindingResult result) {
        List<FieldErrorDetails> errorDetails = new ArrayList<>();
        for (FieldError error : result.getFieldErrors()) {
            errorDetails.add(new FieldErrorDetails(error.getField(), error.getDefaultMessage()));
        }
        this.details.addAll(errorDetails);
    }

    record FieldErrorDetails(String field, String message) {
    }
}
