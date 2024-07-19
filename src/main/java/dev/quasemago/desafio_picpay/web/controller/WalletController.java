package dev.quasemago.desafio_picpay.web.controller;

import dev.quasemago.desafio_picpay.domain.wallet.service.WalletService;
import dev.quasemago.desafio_picpay.web.dto.WalletRequestDTO;
import dev.quasemago.desafio_picpay.web.dto.WalletResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    private final WalletService service;

    public WalletController(WalletService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WalletResponseDTO> createWallet(@Valid @RequestBody WalletRequestDTO requestPayload) {
        final var wallet = service.createWallet(requestPayload);
        return ResponseEntity.status(HttpStatus.CREATED).body(WalletResponseDTO.from(wallet));
    }

    @GetMapping
    public ResponseEntity<List<WalletResponseDTO>> listAllWallets() {
        final List<WalletResponseDTO> responseList = service.listWallets()
                .stream()
                .map(WalletResponseDTO::from)
                .toList();
        return ResponseEntity.ok(responseList);
    }
}
