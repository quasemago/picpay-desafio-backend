package dev.quasemago.desafio_picpay.infra.authorization;

import dev.quasemago.desafio_picpay.domain.transaction.model.Transaction;
import dev.quasemago.desafio_picpay.infra.authorization.exception.PicPayAuthorizationException;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {
    private static final Logger logger = LoggerFactory.getLogger(AuthorizationService.class);
    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    public void authorize(Transaction transaction) {
        logger.info("Autorizando transação {}...", transaction);
        try {
            final var response = authorizationClient.requestAuthorization();
            if (!response.data().authorization()) {
                throw new PicPayAuthorizationException("A transação não foi autorizada!");
            }
        } catch (FeignException ex) {
            throw new PicPayAuthorizationException("Erro durante a autorização da transação.");
        }
    }
}
