package br.com.microservices.cards.application;

import br.com.microservices.cards.domain.ClientCard;
import br.com.microservices.cards.infrastructure.repository.ClientCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientCardService {

    private final ClientCardRepository repository;

    public List<ClientCard> cardByCpf(String cpf){
        return repository.findByCpf(cpf);
    }
}
