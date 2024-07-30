package dev.quasemago.desafio_picpay.web.dto;

import dev.quasemago.desafio_picpay.domain.wallet.model.Wallet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WalletResponseDTO extends RepresentationModel<WalletResponseDTO> {
    private Long id;
    private String name;
    private String registry;
    private String email;
    private BigDecimal balance;
    private String type;

    public static WalletResponseDTO from(Wallet wallet) {
        return new WalletResponseDTO(wallet.getId(),
                wallet.getName(),
                wallet.getRegistry(),
                wallet.getEmail(),
                wallet.getBalance(),
                wallet.getType().name());
    }
}
