package dev.quasemago.desafio_picpay.infra.notification;

import dev.quasemago.desafio_picpay.infra.notification.exception.PicPayNotificationException;
import dev.quasemago.desafio_picpay.domain.transaction.model.Transaction;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);
    private final NotificationClient notificationClient;

    public NotificationService(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    public void notify(Transaction transaction) {
        logger.info("Notificando transação {}...", transaction);
        try {
            notificationClient.sendNotification();
        } catch (FeignException ex) {
            throw new PicPayNotificationException("A transação não foi notificada com sucesso!");
        }
    }
}
