package br.com.microservices.cards.application;

import br.com.microservices.cards.domain.Card;
import br.com.microservices.cards.domain.CardBrand;
import br.com.microservices.cards.dto.CardEnrollRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardsController {

    private final CardService service;

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity enroll(@RequestBody CardEnrollRequestDTO request){
        var card = service.save(new Card(request.name(), CardBrand.valueOf(request.brand()), request.income(), request.baseLimit()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> getCardsByIncome(@RequestParam Long income){
        List<Card> cards = service.getCardByIncomeLessOrEqualThan(income);
        return ResponseEntity.ok(cards);
    }
}
