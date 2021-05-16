package br.com.raizama.raizamaapi.controller.dto;

import br.com.raizama.raizamaapi.modelo.Endereco;

import java.util.List;
import java.util.stream.Collectors;

public class EnderecoDto {
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

    public EnderecoDto(Endereco endereco) {
        this.id = endereco.getId();
        this.latitude = endereco.getLatitude();
        this.longitude = endereco.getLongitude();
        this.pais = endereco.getPais();
        this.estado = endereco.getEstado();
        this.cidade = endereco.getCidade();
        this.logradouro = endereco.getLogradouro();
        this.complemento = endereco.getComplemento();
        this.numero = endereco.getNumero();
        this.cep = endereco.getCep();
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

    public static List<EnderecoDto> converter(List<Endereco> enderecos) {
        return enderecos
                .stream()
                .map(EnderecoDto::new)
                .collect(Collectors.toList());
    }
}
