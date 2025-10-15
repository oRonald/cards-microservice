package br.com.microservices.cards.infrastructure.mqueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CardsPostSubscriber {

    @RabbitListener(queues = "${mq.queue.cards-post}")
    public void receiveRequestIssue(@Payload String payload){
        System.out.println(payload);
    }

}
