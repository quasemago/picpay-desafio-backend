package dev.quasemago.desafio_picpay.domain.transaction.service;

import dev.quasemago.desafio_picpay.domain.transaction.exception.PicPayTransactionException;
import dev.quasemago.desafio_picpay.domain.transaction.model.Transaction;
import dev.quasemago.desafio_picpay.domain.transaction.repository.TransactionRepository;
import dev.quasemago.desafio_picpay.domain.wallet.model.Wallet;
import dev.quasemago.desafio_picpay.domain.wallet.service.WalletService;
import dev.quasemago.desafio_picpay.infra.authorization.AuthorizationService;
import dev.quasemago.desafio_picpay.infra.notification.NotificationService;
import dev.quasemago.desafio_picpay.web.dto.TransferRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final WalletService walletService;
    private final AuthorizationService authorizationService;
    private final NotificationService notificationService;

    public TransactionService(TransactionRepository transactionRepository,
                              WalletService walletService,
                              AuthorizationService authorizationService,
                              NotificationService notificationService) {
        this.transactionRepository = transactionRepository;
        this.walletService = walletService;
        this.authorizationService = authorizationService;
        this.notificationService = notificationService;
    }

    @Transactional
    public Transaction createTransaction(TransferRequestDTO transferPayload) {
        final var payer = walletService.findById(transferPayload.payer());
        final var payee = walletService.findById(transferPayload.payee());
        final var value = transferPayload.value();

        validateTransactionRules(payer, payee, value);

        walletService.updateBalance(payer, payer.getBalance().subtract(value));
        walletService.updateBalance(payee, payee.getBalance().add(value));

        final var transaction = new Transaction(payer, payee);
        transactionRepository.save(transaction);

        authorizationService.authorize(transaction);

        // TODO: run this asynchronously.
        notificationService.notify(transaction);

        return transaction;
    }

    private void validateTransactionRules(Wallet payer, Wallet payee, BigDecimal value) {
        if (payer.getType() == Wallet.WalletType.SELLER) {
            throw new PicPayTransactionException("Lojistas não podem fazer transferências!");
        }
        if (payer == payee) {
            throw new PicPayTransactionException("O pagador e beneficiário não podem ser os mesmos!");
        }
        if (payer.getBalance().compareTo(value) < 0) {
            throw new PicPayTransactionException("O pagador não possui saldo suficiente para esta transferência.");
        }
    }

    @Transactional(readOnly = true)
    public List<Transaction> listTransactions() {
        return transactionRepository.findAll();
    }
}
