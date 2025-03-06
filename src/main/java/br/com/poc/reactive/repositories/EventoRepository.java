package br.com.poc.reactive.repositories;

import br.com.poc.reactive.entities.Evento;
import br.com.poc.reactive.enums.TipoEvento;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface EventoRepository extends ReactiveCrudRepository<Evento, Long> {
   Flux<Evento> findByTipo(TipoEvento tipoEvento);
}