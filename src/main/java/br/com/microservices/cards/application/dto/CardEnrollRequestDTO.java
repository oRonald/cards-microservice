package br.com.microservices.cards.application.dto;

import java.math.BigDecimal;

public record CardEnrollRequestDTO(String name, String brand, BigDecimal income, BigDecimal baseLimit) {
}
