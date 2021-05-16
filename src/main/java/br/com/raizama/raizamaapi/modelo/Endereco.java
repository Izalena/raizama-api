package br.com.raizama.raizamaapi.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long latitude;
    private Long longitude;
    private String pais;
    private String estado;
    private String cidade;
    private String logradouro;
    private String complemento;
    private int numero;
    private int cep;

    public Endereco() {}

    public Endereco(Long latitude, Long longitude, String pais, String estado, String cidade, String logradouro, String complemento, int numero, int cep) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.numero = numero;
        this.cep = cep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco)) return false;
        Endereco endereco = (Endereco) o;
        return numero == endereco.numero && cep == endereco.cep && id.equals(endereco.id) && Objects.equals(latitude, endereco.latitude) && Objects.equals(longitude, endereco.longitude) && Objects.equals(pais, endereco.pais) && Objects.equals(estado, endereco.estado) && Objects.equals(cidade, endereco.cidade) && Objects.equals(logradouro, endereco.logradouro) && Objects.equals(complemento, endereco.complemento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, latitude, longitude, pais, estado, cidade, logradouro, complemento, numero, cep);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }
}
