package br.com.raizama.raizamaapi.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Estabelecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeFantasia;
    @ManyToOne
    private Endereco endereco;
    @ManyToMany
    private List<Pratica> praticas = new ArrayList<>();

    public Estabelecimento() {}

    public Estabelecimento(String nomeFantasia,
                           Endereco endereco,
                           List<Pratica> praticas) {
        this.nomeFantasia = nomeFantasia;
        this.endereco = endereco;
        this.praticas = praticas;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estabelecimento)) return false;
        Estabelecimento that = (Estabelecimento) o;
        return id == that.id && Objects.equals(nomeFantasia, that.nomeFantasia) && Objects.equals(endereco, that.endereco) && Objects.equals(praticas, that.praticas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeFantasia, endereco, praticas);
    }
}
