package br.com.raizama.raizamaapi.controller.form;

import br.com.raizama.raizamaapi.modelo.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizacaoEstabelecimentoForm {
    @NotNull @NotEmpty
    private String nomeFantasia;
    @NotNull @NotEmpty
    private String tipo;
    @NotNull @NotEmpty
    private Long latitude;
    @NotNull @NotEmpty
    private Long longitude;
    @NotNull @NotEmpty
    private String pais;
    @NotNull @NotEmpty
    private String estado;
    @NotNull @NotEmpty
    private String cidade;
    @NotNull @NotEmpty
    private String logradouro;

    private String complemento;
    @NotNull @NotEmpty
    private int numero;

    private int cep;

    private List<String> praticas;


    public Endereco converter() {
        return new Endereco(
                latitude,
                longitude,
                pais,
                estado,
                cidade,
                logradouro,
                complemento,
                numero,
                cep);
    }
}
