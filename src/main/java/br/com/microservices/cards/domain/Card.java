package br.com.microservices.cards.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardBrand brand;

    @Column(nullable = false)
    private BigDecimal income;

    @Column(nullable = false)
    private BigDecimal baseLimit;

    public Card(String name, CardBrand brand, BigDecimal income, BigDecimal baseLimit) {
        this.name = name;
        this.brand = brand;
        this.income = income;
        this.baseLimit = baseLimit;
    }
}
