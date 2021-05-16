package br.com.raizama.raizamaapi.controller.dto;

import br.com.raizama.raizamaapi.modelo.Endereco;
import br.com.raizama.raizamaapi.modelo.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioDto {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String dataNascimento;
    private Endereco endereco;

    public UsuarioDto(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.dataNascimento = usuario.getDataNascimento();
        this.endereco = usuario.getEndereco();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public static List<UsuarioDto> converter(List<Usuario> usuarios) {
        return usuarios
                .stream()
                .map(UsuarioDto::new)
                .collect(Collectors.toList());
    }
}
