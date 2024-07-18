package dev.quasemago.desafio_picpay.domain.transaction.model;

import dev.quasemago.desafio_picpay.domain.wallet.model.Wallet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "TRANSACTIONS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    @JoinColumn(name = "payer_id")
    private Wallet payer;
    @ManyToOne
    @JoinColumn(name = "payee_id")
    private Wallet payee;
    @CreatedDate
    private LocalDateTime date;

    public Transaction(Wallet payer, Wallet payee) {
        this.payer = payer;
        this.payee = payee;
    }
}
