package br.com.poc.reactive.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("vendas")
public class Venda {
    @Id
    private Long id;
    private Long ingressoId;
    private int total;

}