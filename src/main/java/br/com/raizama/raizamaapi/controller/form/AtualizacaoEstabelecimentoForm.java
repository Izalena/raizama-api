package br.com.raizama.raizamaapi.controller.form;

import br.com.raizama.raizamaapi.modelo.Endereco;
import br.com.raizama.raizamaapi.modelo.Estabelecimento;
import br.com.raizama.raizamaapi.modelo.Pratica;
import br.com.raizama.raizamaapi.repository.EstabelecimentoRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class AtualizacaoEstabelecimentoForm {
    @NotNull
    @NotEmpty
    @Length(max = 50)
    private String nomeFantasia;
    private Endereco endereco;
    private List<Pratica> praticas = new ArrayList<>();

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

    public Estabelecimento atualizar(Long id, EstabelecimentoRepository estabelecimentoRepository) {
        Estabelecimento estabelecimento = estabelecimentoRepository.getOne(id);

        estabelecimento.setEndereco(endereco);
        estabelecimento.setNomeFantasia(nomeFantasia);
        estabelecimento.setPraticas(praticas);

        return estabelecimento;
    }
}
