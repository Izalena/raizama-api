package br.com.raizama.raizamaapi.controller.form;

import br.com.raizama.raizamaapi.modelo.Endereco;
import br.com.raizama.raizamaapi.modelo.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuarioForm {
    @NotNull
    @NotEmpty
    @Length(max = 80)
    private String nome;
    @NotNull @NotEmpty @Length(max = 50)
    private String email;
    @NotNull @NotEmpty @Length(min = 5, max = 8)
    private String senha;
    @NotNull @NotEmpty @Length(max=10)
    private String dataNascimento;
    private Endereco endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Usuario converter() {
        return new Usuario(nome, email, senha, dataNascimento, endereco);
    }
}
