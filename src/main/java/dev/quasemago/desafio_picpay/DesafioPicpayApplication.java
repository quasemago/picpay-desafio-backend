package dev.quasemago.desafio_picpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableFeignClients
@EnableJpaAuditing
@EnableAsync
public class DesafioPicpayApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesafioPicpayApplication.class, args);
    }

}
