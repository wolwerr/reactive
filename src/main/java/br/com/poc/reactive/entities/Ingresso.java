package br.com.poc.reactive.entities;


import br.com.poc.reactive.enums.TipoIngresso;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("ingressos")
public class Ingresso {
    @Id
    private Long id;
    private Long eventoId;
    private TipoIngresso tipo;
    private Double valor;
    private int total;

}
