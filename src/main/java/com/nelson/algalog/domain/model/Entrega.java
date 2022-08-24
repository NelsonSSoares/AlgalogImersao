package com.nelson.algalog.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//@JoinColumn(name = "")
	@ManyToOne
	private Cliente cliente;
	
	
	@Embedded //indica que este campo é uma "tabela" completa a ser iserida dentro desta tabela com seus proprios atributos
	private Destinatario destinatario;
	
	private BigDecimal taxa;
	//String armazeno o texto do enum, nao a ordem do array ex: 1,2,3
	@Enumerated(EnumType.STRING)
	private StatusEntrega status;
	private LocalDateTime dataPedido;
	private LocalDateTime dataFinalizacao;
	
	

	
	
}
