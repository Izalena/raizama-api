package br.com.raizama.raizamaapi.controller.form;

import br.com.raizama.raizamaapi.modelo.Pratica;

import javax.validation.constraints.NotNull;

public class PraticaForm {
    @NotNull
    private String pratica;

    public String getPratica() {
        return pratica;
    }

    public void setPratica(String pratica) {
        this.pratica = pratica;
    }

    public Pratica converter() {
        return new Pratica(pratica);
    }
}
