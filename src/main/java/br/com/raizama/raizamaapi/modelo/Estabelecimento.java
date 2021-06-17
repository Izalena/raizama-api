package br.com.raizama.raizamaapi.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Estabelecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeFantasia;
    private String tipo;
    private Long latitude;
    private Long longitude;
    private String pais;
    private String estado;
    private String cidade;
    private String logradouro;
    private String complemento;
    private int numero;
    private int cep;
    @ElementCollection
    private List<String> praticas;


    public Estabelecimento(String nomeFantasia,
                           String tipo,
                           Long latitude,
                           Long longitude,
                           String pais,
                           String estado,
                           String cidade,
                           String logradouro,
                           String complemento,
                           int numero,
                           int cep,
                           List<String> praticas) {
        this.nomeFantasia = nomeFantasia;
        this.tipo = tipo;
        this.latitude = latitude;
        this.longitude = longitude;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.numero = numero;
        this.cep = cep;
        this.praticas = praticas;
    }
}
