package dev.quasemago.desafio_picpay.web.dto;

import dev.quasemago.desafio_picpay.domain.transaction.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferResponseDTO extends RepresentationModel<TransferResponseDTO> {
    private String transactionId;
    private LocalDateTime date;

    public static TransferResponseDTO from(Transaction transaction) {
        return new TransferResponseDTO(transaction.getId(),
                transaction.getDate());
    }
}
