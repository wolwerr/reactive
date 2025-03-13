package br.com.poc.reactive.repositories;

import br.com.poc.reactive.entities.Ingresso;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IngressoRepository extends ReactiveCrudRepository<Ingresso, Long> {
}
