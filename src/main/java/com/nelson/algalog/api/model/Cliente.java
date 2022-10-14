package com.nelson.algalog.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode; //tambem disponivel no source->generate equals and hashCode

//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
//@Table(name= "Cliente" )especifica o nome da tabela no banco de dados

@EqualsAndHashCode(onlyExplicitlyIncluded = true) // compara objetos jaava no caso especificando o ID
@Entity //CLASSE QUE REPRESENTA ENTIDADE
public class Cliente {
	
	
	@EqualsAndHashCode.Include //inclui na verificação de equals and hashCode
	@Id // Id chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)// autoincrement do mysql
	private Long id;
	
	private String name;
	private String email;
	
	//@Column(name = "phone") //especfica o nome da coluna no banco de dados
	private String telefone;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", name=" + name + ", email=" + email + ", telefone=" + telefone + "]";
	}
	
	
}
