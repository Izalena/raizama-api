package br.com.raizama.raizamaapi.controller.form;

import br.com.raizama.raizamaapi.controller.dto.EstabelecimentoDto;
import br.com.raizama.raizamaapi.modelo.Endereco;
import br.com.raizama.raizamaapi.modelo.Estabelecimento;
import br.com.raizama.raizamaapi.modelo.Pratica;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstabelecimentoForm {
    @NotNull
    @NotEmpty
    @Length(max = 50)
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


    public Estabelecimento converter() {
        return new Estabelecimento(
                nomeFantasia,
                tipo,
                latitude,
                longitude,
                pais,
                estado,
                cidade,
                logradouro,
                complemento,
                numero,
                cep,
                praticas);
    }
}
