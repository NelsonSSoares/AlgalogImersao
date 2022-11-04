package com.nelson.algalog.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
	
	//JAKARTA BEAN VALIDATION
	//@NotNull nao permite campo nulo
	@Size(max= 60)//tamanho maximo
	@NotBlank // nao permita campo vazio  e nulo
	private String name;
	
	@Email // validação de email com @ e .com
	@Size(max = 255)
	private String email;
	
	//@Column(name = "phone") //especfica o nome da coluna no banco de dados
	@NotBlank
	@Size(max = 20)
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
