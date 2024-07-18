package dev.quasemago.desafio_picpay.domain.wallet.repository;

import dev.quasemago.desafio_picpay.domain.wallet.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
