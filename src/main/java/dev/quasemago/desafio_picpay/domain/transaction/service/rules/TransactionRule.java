package dev.quasemago.desafio_picpay.domain.transaction.service.rules;

import dev.quasemago.desafio_picpay.domain.transaction.exception.PicPayTransactionException;
import dev.quasemago.desafio_picpay.domain.wallet.model.Wallet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public interface TransactionRule {
    void validate(Wallet payer, Wallet payee, BigDecimal value) throws PicPayTransactionException;
}
