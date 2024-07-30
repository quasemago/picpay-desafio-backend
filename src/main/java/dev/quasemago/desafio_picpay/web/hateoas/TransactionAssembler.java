package dev.quasemago.desafio_picpay.web.hateoas;

import dev.quasemago.desafio_picpay.domain.transaction.model.Transaction;
import dev.quasemago.desafio_picpay.web.controller.TransactionController;
import dev.quasemago.desafio_picpay.web.dto.TransferResponseDTO;
import jakarta.annotation.Nonnull;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class TransactionAssembler implements RepresentationModelAssembler<Transaction, TransferResponseDTO> {
    @Nonnull
    @Override
    public TransferResponseDTO toModel(@Nonnull Transaction transaction) {
        final var dto = TransferResponseDTO.from(transaction);
        dto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TransactionController.class)
                .getTransactionById(transaction.getId())).withSelfRel());
        return dto;
    }
}
