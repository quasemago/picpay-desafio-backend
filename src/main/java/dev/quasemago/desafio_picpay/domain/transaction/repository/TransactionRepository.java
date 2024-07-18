package dev.quasemago.desafio_picpay.domain.transaction.repository;

import dev.quasemago.desafio_picpay.domain.transaction.model.Transaction;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    @Nonnull
    Optional<Transaction> findById(@Nonnull String id);
}
