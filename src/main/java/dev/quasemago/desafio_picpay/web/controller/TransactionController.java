package dev.quasemago.desafio_picpay.web.controller;

import dev.quasemago.desafio_picpay.domain.transaction.service.TransactionService;
import dev.quasemago.desafio_picpay.web.dto.TransferRequestDTO;
import dev.quasemago.desafio_picpay.web.dto.TransferResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfer")
public class TransactionController {
    private final TransactionService service;

    public TransactionController(TransactionService transactionService) {
        this.service = transactionService;
    }

    @PostMapping()
    public ResponseEntity<TransferResponseDTO> createTransaction(@Valid @RequestBody TransferRequestDTO requestPayload) {
        final var transaction = service.createTransaction(requestPayload);
        return ResponseEntity.ok(TransferResponseDTO.from(transaction.getId(), transaction.getDate()));
    }

    @GetMapping()
    public ResponseEntity<List<TransferResponseDTO>> listAllTransactions() {
        final List<TransferResponseDTO> responseList = service.listTransactions()
                .stream()
                .map(transaction -> TransferResponseDTO.from(transaction.getId(), transaction.getDate()))
                .toList();
        return ResponseEntity.ok(responseList);
    }
}
