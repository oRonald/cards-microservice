package br.com.microservices.cards.application;

import br.com.microservices.cards.domain.Card;
import br.com.microservices.cards.domain.CardBrand;
import br.com.microservices.cards.domain.ClientCard;
import br.com.microservices.cards.application.dto.CardEnrollRequestDTO;
import br.com.microservices.cards.application.dto.CardsByClientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardsController {

    private final CardService service;
    private final ClientCardService clientCardService;

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity enroll(@RequestBody CardEnrollRequestDTO request){
        var card = service.save(new Card(request.name(), CardBrand.valueOf(request.brand()), request.income(), request.baseLimit()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "income", path = "/by-income")
    public ResponseEntity<List<Card>> getCardsByIncome(@RequestParam Long income){
        List<Card> cards = service.getCardByIncomeLessOrEqualThan(income);
        return ResponseEntity.ok(cards);
    }

    @GetMapping(params = "cpf", path = "by-cpf")
    public ResponseEntity<List<CardsByClientResponse>> cardByClients(@RequestParam String cpf){
        List<ClientCard> clientCards = clientCardService.cardByCpf(cpf);
        return ResponseEntity.ok(CardsByClientResponse.from(clientCards));
    }
}
