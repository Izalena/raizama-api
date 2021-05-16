package br.com.raizama.raizamaapi.controller.dto;

import br.com.raizama.raizamaapi.modelo.Pratica;

import java.util.List;
import java.util.stream.Collectors;

public class PraticaDto {
    private Long id;
    private String pratica;

    public PraticaDto(Pratica pratica) {
        this.id = pratica.getId();
        this.pratica = pratica.getPratica();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPratica() {
        return pratica;
    }

    public void setPratica(String pratica) {
        this.pratica = pratica;
    }

    public static List<PraticaDto> converter(List<Pratica> praticas) {
        return praticas
                .stream()
                .map(PraticaDto::new)
                .collect(Collectors.toList());
    }
}
