package br.com.raizama.raizamaapi.controller.dto;

import br.com.raizama.raizamaapi.modelo.Endereco;
import br.com.raizama.raizamaapi.modelo.Estabelecimento;
import br.com.raizama.raizamaapi.modelo.Pratica;

import java.util.List;
import java.util.stream.Collectors;

public class EstabelecimentoDto {
    private long id;
    private String nomeFantasia;
    private Endereco endereco;
    private List<Pratica> praticas;

    public EstabelecimentoDto (Estabelecimento estabelecimento) {
        this.id = estabelecimento.getId();
        this.nomeFantasia = estabelecimento.getNomeFantasia();
        this.endereco = estabelecimento.getEndereco();
        this.praticas = estabelecimento.getPraticas();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Pratica> getPraticas() {
        return praticas;
    }

    public void setPraticas(List<Pratica> praticas) {
        this.praticas = praticas;
    }
    public static List<EstabelecimentoDto> converter(List<Estabelecimento> estabelecimentos) {
        return estabelecimentos
                .stream()
                .map(EstabelecimentoDto::new)
                .collect(Collectors.toList());
    }
}
