package dev.quasemago.desafio_picpay.web.hateoas;

import dev.quasemago.desafio_picpay.domain.wallet.model.Wallet;
import dev.quasemago.desafio_picpay.web.controller.WalletController;
import dev.quasemago.desafio_picpay.web.dto.WalletResponseDTO;
import jakarta.annotation.Nonnull;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class WalletAssembler implements RepresentationModelAssembler<Wallet, WalletResponseDTO> {
    @Nonnull
    @Override
    public WalletResponseDTO toModel(@Nonnull Wallet wallet) {
        final var dto = WalletResponseDTO.from(wallet);
        dto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(WalletController.class)
                .getWalletById(wallet.getId())).withSelfRel());
        return dto;
    }
}