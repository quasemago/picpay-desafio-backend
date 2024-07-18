package dev.quasemago.desafio_picpay.infra.authorization;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        value = "authorization-client",
        url = "${picpay.authorization-url}"
)
public interface AuthorizationClient {
    @GetMapping
    AuthorizationResponse requestAuthorization();
}
