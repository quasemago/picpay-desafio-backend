package dev.quasemago.desafio_picpay.web.controller;

import dev.quasemago.desafio_picpay.domain.wallet.service.WalletService;
import dev.quasemago.desafio_picpay.web.dto.WalletRequestDTO;
import dev.quasemago.desafio_picpay.web.dto.WalletResponseDTO;
import dev.quasemago.desafio_picpay.web.hateoas.WalletAssembler;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    private final WalletService service;
    private final WalletAssembler assembler;

    public WalletController(WalletService service,
                            WalletAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @PostMapping
    public ResponseEntity<WalletResponseDTO> createWallet(@Valid @RequestBody WalletRequestDTO requestPayload) {
        final var wallet = service.createWallet(requestPayload);
        return ResponseEntity.status(HttpStatus.CREATED).body(WalletResponseDTO.from(wallet));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WalletResponseDTO> getWalletById(@PathVariable Long id) {
        final var response = assembler.toModel(service.findById(id));
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<CollectionModel<WalletResponseDTO>> listAllWallets() {
        final CollectionModel<WalletResponseDTO> response = assembler.toCollectionModel(service.listWallets());
        return ResponseEntity.ok(response);
    }
}
