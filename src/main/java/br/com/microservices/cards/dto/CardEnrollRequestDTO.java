package br.com.microservices.cards.dto;

import java.math.BigDecimal;

public record CardEnrollRequestDTO(String name, String brand, BigDecimal income, BigDecimal baseLimit) {
}
