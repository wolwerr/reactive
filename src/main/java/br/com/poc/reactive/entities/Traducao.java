package br.com.poc.reactive.entities;

import java.util.List;

public record Traducao(List<Texto> translations) {

    public String getTexto() {
        return translations.getFirst().text();
    }
}
