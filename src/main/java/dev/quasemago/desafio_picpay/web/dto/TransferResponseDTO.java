package dev.quasemago.desafio_picpay.web.dto;

import java.time.LocalDateTime;

public record TransferResponseDTO(String transactionId, LocalDateTime date) {
    public static TransferResponseDTO from(String transactionId, LocalDateTime date) {
        return new TransferResponseDTO(transactionId, date);
    }
}
