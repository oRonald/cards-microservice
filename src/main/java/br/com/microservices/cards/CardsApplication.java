package br.com.microservices.cards;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableRabbit
@Slf4j
public class CardsApplication {

	public static void main(String[] args) {
		log.info("Info: {}", "info test");
		log.error("Error: {}", "error test");
		log.warn("Warn: {}", "warn test");
		SpringApplication.run(CardsApplication.class, args);
	}

}
