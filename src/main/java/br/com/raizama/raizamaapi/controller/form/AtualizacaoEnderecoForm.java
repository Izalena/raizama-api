package br.com.raizama.raizamaapi.controller.form;

import br.com.raizama.raizamaapi.modelo.Endereco;
import br.com.raizama.raizamaapi.repository.EnderecoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizacaoEnderecoForm {

	@NotNull
	private Long id;
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

	public Endereco atualizar(Long id, EnderecoRepository enderecoRepository) {
		Endereco endereco = enderecoRepository.getOne(id);

		endereco.setCep(this.cep);
		endereco.setCidade(this.cidade);
		endereco.setPais(this.pais);
		endereco.setEstado(this.estado);
		endereco.setNumero(this.numero);
		endereco.setComplemento(this.complemento);
		endereco.setLatitude(this.latitude);
		endereco.setLongitude(this.longitude);
		
		return endereco;
	}
	
}
