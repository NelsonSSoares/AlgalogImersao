package com.nelson.algalog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelson.algalog.domain.model.Cliente;

@RestController 
public class ClienteController {
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		
		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setNome("Nelson");
		cliente.setEmail("exemplo@exemplar.com");
		cliente.setTelefone("5511953572284");
		
		Cliente cliente2 = new Cliente();
		cliente2.setId(2);
		cliente2.setNome("Noeme");
		cliente2.setEmail("exemplar@exemplo.com");
		cliente2.setTelefone("5511958791414");
		
		return Arrays.asList(cliente,cliente2) ;
	}
}
