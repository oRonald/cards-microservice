package br.com.microservices.cards.application.dto;

import br.com.microservices.cards.domain.ClientCard;

import java.math.BigDecimal;
import java.util.List;

public record CardsByClientResponse(String name, String brand, BigDecimal cardLimit) {

    public static List<CardsByClientResponse> from(List<ClientCard> clientCards) {
        return clientCards.stream()
                .map(c -> new CardsByClientResponse(
                        c.getCard().getName(),
                        String.valueOf(c.getCard().getBrand()),
                        c.getCard().getBaseLimit()))
                .toList();
    }

}
