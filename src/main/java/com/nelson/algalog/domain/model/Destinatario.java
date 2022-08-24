package com.nelson.algalog.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//@Getter
//@Setter
@Embeddable //indica que esta classe é usada como campo de uma de uma tabela e nao uma tabela unica Destinatario
public class Destinatario {
	
	@Column(name = "destinario_nome")
	private String nome;
	
	@Column(name = "destinario_logradouro")
	private String logradouro;
	
	@Column(name = "destinario_complemento")
	private String complemento;
	
	@Column(name = "destinario_bairro")
	private String bairro;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
}
