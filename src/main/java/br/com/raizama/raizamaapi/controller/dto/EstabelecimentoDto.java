package br.com.raizama.raizamaapi.controller.dto;

import br.com.raizama.raizamaapi.modelo.Endereco;
import br.com.raizama.raizamaapi.modelo.Estabelecimento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstabelecimentoDto {
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
    private List<String> praticas;

    public EstabelecimentoDto(Estabelecimento estabelecimento) {
        this.id = estabelecimento.getId();
        this.nomeFantasia = estabelecimento.getNomeFantasia();
        this.tipo = estabelecimento.getTipo();
        this.latitude = estabelecimento.getLatitude();
        this.longitude = estabelecimento.getLongitude();
        this.pais = estabelecimento.getPais();
        this.estado = estabelecimento.getEstado();
        this.cidade = estabelecimento.getCidade();
        this.logradouro = estabelecimento.getLogradouro();
        this.complemento = estabelecimento.getComplemento();
        this.numero = estabelecimento.getNumero();
        this.cep = estabelecimento.getCep();
        this.praticas = estabelecimento.getPraticas();
    }

    public static List<EstabelecimentoDto> converter(List<Estabelecimento> estabelecimentos) {
        return estabelecimentos
                .stream()
                .map(EstabelecimentoDto::new)
                .collect(Collectors.toList());
    }

}
