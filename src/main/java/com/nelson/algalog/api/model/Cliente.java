package com.nelson.algalog.api.model;

//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
public class Cliente {
	
	private Long id;
	private String name;
	private String email;
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