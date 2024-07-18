package dev.quasemago.desafio_picpay.infra.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        value = "notification-client",
        url = "${picpay.notification-url}"
)
public interface NotificationClient {
    @GetMapping
    NotificationResponse sendNotification();
}
