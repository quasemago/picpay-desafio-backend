package dev.quasemago.desafio_picpay.domain.transaction.service.rules;

import dev.quasemago.desafio_picpay.domain.transaction.exception.PicPayTransactionException;
import dev.quasemago.desafio_picpay.domain.wallet.model.Wallet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SufficientBalanceRule implements TransactionRule {
    @Override
    public void validate(Wallet payer, Wallet payee, BigDecimal value) {
        if (payer.getBalance().compareTo(value) < 0) {
            throw new PicPayTransactionException("O pagador não possui saldo suficiente para esta transferência.");
        }
    }
}
