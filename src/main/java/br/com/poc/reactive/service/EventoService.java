package br.com.poc.reactive.service;

import br.com.poc.reactive.dto.EventoDto;
import br.com.poc.reactive.enums.TipoEvento;
import br.com.poc.reactive.repositories.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EventoService {

    private final EventoRepository eventoRepository;

    public Flux<EventoDto> obterTodos() {
        return eventoRepository.findAll()
                .map(EventoDto::toDto);
    }

    public Mono<EventoDto> obterPorId(Long id) {
        return  eventoRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map(EventoDto::toDto);
    }

    public Mono<EventoDto> cadastrar(EventoDto dto) {
        return eventoRepository.save(dto.toEntity())
                .map(EventoDto::toDto);
    }
    public Mono<Void> excluir(Long id) {
        return eventoRepository.findById(id)
                .flatMap(eventoRepository::delete);
    }

    public Mono<EventoDto> alterarCadastro(Long id, EventoDto dto) {
        return eventoRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Id do evento não encontrado.")))
                .flatMap(eventoExistente -> {
                    eventoExistente.setTipo(dto.tipo());
                    eventoExistente.setNome(dto.nome());
                    eventoExistente.setData(dto.data());
                    eventoExistente.setDescricao(dto.descricao());
                    return eventoRepository.save(eventoExistente);
                })
                .map(EventoDto::toDto);
    }

    public Flux<EventoDto> obterPorTipo(String tipo) {
        TipoEvento tipoEvento = TipoEvento.valueOf(tipo.toUpperCase());
        return eventoRepository.findByTipo(tipoEvento)
                .map(EventoDto::toDto);
    }
}