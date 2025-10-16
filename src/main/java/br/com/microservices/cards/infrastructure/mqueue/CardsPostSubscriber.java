package br.com.microservices.cards.infrastructure.mqueue;

import br.com.microservices.cards.domain.Card;
import br.com.microservices.cards.domain.ClientCard;
import br.com.microservices.cards.domain.RequestCardData;
import br.com.microservices.cards.infrastructure.repository.CardRepository;
import br.com.microservices.cards.infrastructure.repository.ClientCardRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CardsPostSubscriber {

    private final CardRepository repository;
    private final ClientCardRepository clientCardRepository;

    @RabbitListener(queues = "${mq.queue.cards-post}")
    public void receiveRequestIssue(@Payload String payload){
        try{
            var mapper = new ObjectMapper();
            RequestCardData data = mapper.readValue(payload, RequestCardData.class);
            Card card = repository.findById(data.getCardId()).orElseThrow();
            ClientCard clientCard = new ClientCard();
            clientCard.setCard(card);
            clientCard.setCpf(data.getCpf());
            clientCard.setCardLimit(data.getCardLimit());
            System.out.println(data.getCardLimit());

            clientCardRepository.save(clientCard);
        } catch (Exception e){
            log.error("Error receiving request to card post: {}", e.getMessage());
        }
    }

}
