package com.nelson.algalog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelson.algalog.api.model.Cliente;

@RestController
public class ClienteController {
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		
		Cliente cliente1 = new Cliente();
		
		cliente1.setId(1L);
		cliente1.setName("Nelson");
		cliente1.setEmail("nelson@ibm.com");
		cliente1.setTelefone("95450-3074");
		
		
		Cliente cliente2 = new Cliente();
		
		cliente2.setId(2L);
		cliente2.setName("Noeme");
		cliente2.setEmail("noemenono@gmail.com");
		cliente2.setTelefone("91234-5678");
		
		return Arrays.asList(cliente1,cliente2);
	}
}
