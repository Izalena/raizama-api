package br.com.raizama.raizamaapi.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Pratica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pratica;

    public Pratica() {}

    public Pratica(String pratica) {
        this.pratica = pratica;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pratica)) return false;
        Pratica pratica = (Pratica) o;
        return id.equals(pratica.id) && this.pratica.equals(pratica.pratica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pratica);
    }
}
