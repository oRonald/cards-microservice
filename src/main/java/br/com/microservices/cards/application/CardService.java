package br.com.microservices.cards.application;

import br.com.microservices.cards.domain.Card;
import br.com.microservices.cards.infrastructure.repository.CardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository repository;

    @Transactional
    public Card save(Card card){
        return repository.save(card);
    }

    public List<Card> getCardByIncomeLessOrEqualThan(Long income){
        var incomeConverted = BigDecimal.valueOf(income);
        return repository.findByIncomeLessThanEqual(incomeConverted);
    }
}
