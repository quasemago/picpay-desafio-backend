package dev.quasemago.desafio_picpay.web.controller;

import dev.quasemago.desafio_picpay.domain.transaction.service.TransactionService;
import dev.quasemago.desafio_picpay.web.dto.TransferRequestDTO;
import dev.quasemago.desafio_picpay.web.dto.TransferResponseDTO;
import dev.quasemago.desafio_picpay.web.hateoas.TransactionAssembler;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfer")
public class TransactionController {
    private final TransactionService service;
    private final TransactionAssembler assembler;

    public TransactionController(TransactionService transactionService,
                                 TransactionAssembler transactionAssembler) {
        this.service = transactionService;
        this.assembler = transactionAssembler;
    }

    @PostMapping()
    public ResponseEntity<TransferResponseDTO> createTransaction(@Valid @RequestBody TransferRequestDTO requestPayload) {
        final var response = assembler.toModel(service.createTransaction(requestPayload));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTransactionById(@PathVariable String id) {
        final var response = assembler.toModel(service.getTransactionById(id));
        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<CollectionModel<TransferResponseDTO>> listAllTransactions() {
        final CollectionModel<TransferResponseDTO> response = assembler.toCollectionModel(service.listTransactions());
        return ResponseEntity.ok(response);
    }
}
