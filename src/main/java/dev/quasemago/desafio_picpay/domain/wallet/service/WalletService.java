package dev.quasemago.desafio_picpay.domain.wallet.service;

import dev.quasemago.desafio_picpay.domain.wallet.exception.PicPayWalletNotFoundException;
import dev.quasemago.desafio_picpay.domain.wallet.model.Wallet;
import dev.quasemago.desafio_picpay.domain.wallet.repository.WalletRepository;
import dev.quasemago.desafio_picpay.domain.wallet.service.factory.WalletFactoryProvider;
import dev.quasemago.desafio_picpay.web.dto.WalletRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class WalletService {
    private final WalletRepository repository;

    public WalletService(WalletRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Wallet createWallet(WalletRequestDTO requestPayload) {
        final var factory = WalletFactoryProvider.getFactory(requestPayload.type());
        final var wallet = factory.createWallet(requestPayload.name(),
                requestPayload.registry(),
                requestPayload.email(),
                requestPayload.password(),
                requestPayload.balance());
        return repository.save(wallet);
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

    @Transactional(readOnly = true)
    public List<Wallet> listWallets() {
        return repository.findAll();
    }
}
