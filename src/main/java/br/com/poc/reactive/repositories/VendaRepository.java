package br.com.poc.reactive.repositories;

import br.com.poc.reactive.entities.Venda;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface VendaRepository extends ReactiveCrudRepository<Venda, Long> {
}
