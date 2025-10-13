package br.com.microservices.cards.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class ClientCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "id_card", nullable = false)
    private Card card;

    @Column(nullable = false)
    private BigDecimal cardLimit;
}
