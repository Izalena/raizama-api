package br.com.raizama.raizamaapi.controller.form;

import br.com.raizama.raizamaapi.modelo.Pratica;
import br.com.raizama.raizamaapi.repository.PraticaRepository;

import javax.validation.constraints.NotNull;

public class AtualizacaoPraticaForm {
    @NotNull
    private String pratica;

    public String getPratica() {
        return pratica;
    }

    public void setPratica(String pratica) {
        this.pratica = pratica;
    }

    public Pratica atualizar(Long id, PraticaRepository praticaRepository) {
        Pratica praticaTipo = praticaRepository.getOne(id);
        praticaTipo.setPratica(pratica);

        return praticaTipo;
    }
}
