package dev.quasemago.desafio_picpay.domain.wallet.model;

import dev.quasemago.desafio_picpay.domain.wallet.service.validation.WalletRegistryValidation;
import dev.quasemago.desafio_picpay.domain.wallet.service.validation.WalletRegistryValidationFactory;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Entity
@Table(name = "WALLETS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(unique = true, nullable = false)
    @Length(min = 11, max = 14)
    private String registry;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private WalletType type;

    public enum WalletType {
        USER, SELLER
    }

    public Wallet(String name, String registry, String email, String password, BigDecimal balance, WalletType type) {
        this.name = name;
        this.registry = registry;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.type = type;
    }

    public boolean isRegistryValid() {
        WalletRegistryValidation strategy = WalletRegistryValidationFactory.getStrategy(this.type);
        return strategy.validate(this.registry);
    }
}