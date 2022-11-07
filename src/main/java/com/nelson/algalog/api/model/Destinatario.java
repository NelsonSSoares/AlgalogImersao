package com.nelson.algalog.api.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable //indica que esta classe pode ser usada uma como uma coluna de outra tabela aonde houver anotação 
public class Destinatario {
	
	@Column(name = "destinatario_nome")
	private String nome;
	
	@Column(name = "destinatario_logradouro")
	private String logradouro;
	
	@Column(name = "destinatario_numero")
	private String numero;
	
	@Column(name = "destinatario_complemento")
	private String complemento;
	
	@Column(name = "destinatario_bairro")
	private String bairro;
}
