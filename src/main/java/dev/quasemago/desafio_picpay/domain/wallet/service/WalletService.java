package dev.quasemago.desafio_picpay.domain.wallet.service;

import dev.quasemago.desafio_picpay.domain.wallet.exception.PicPayWalletNotFoundException;
import dev.quasemago.desafio_picpay.domain.wallet.model.Wallet;
import dev.quasemago.desafio_picpay.domain.wallet.repository.WalletRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class WalletService {
    private final WalletRepository repository;

    public WalletService(WalletRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Wallet findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PicPayWalletNotFoundException("Wallet id " + id + " not found"));
    }

    @Transactional
    public void updateBalance(Wallet wallet, BigDecimal newValue) {
        wallet.setBalance(newValue);
        repository.save(wallet);
    }
}
