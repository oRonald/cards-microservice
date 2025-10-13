package br.com.microservices.cards.infrastructure.repository;

import br.com.microservices.cards.domain.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientCardRepository extends JpaRepository<ClientCard, Long> {

    List<ClientCard> findByCpf(String cpf);
}
