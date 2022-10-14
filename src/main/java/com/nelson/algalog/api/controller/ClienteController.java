package com.nelson.algalog.api.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nelson.algalog.api.model.Cliente;
import com.nelson.algalog.domain.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	
	@Autowired //injeção de depedencia, procurada automaticamente pelo nome identico
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> listar() {
			
		return clienteRepository.findAll();	
	}
	
	@GetMapping("/{clienteId}") // @pathvariable indica a variavel passada no paremetro da pasta da requisição
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {

		return clienteRepository.findById(clienteId)
				.map(cliente -> ResponseEntity.ok(cliente))
				.orElse(ResponseEntity.notFound().build());
			
//		Optional<Cliente> cliente = clienteRepository.findById(clienteId);	
//		if(cliente.isPresent()) {
//			return ResponseEntity.ok(cliente.get());
//		}
//		return ResponseEntity.notFound().build();
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) // indica status 201 se cliente for criado
	public Cliente newCliente(@RequestBody Cliente cliente) {	
		
		return clienteRepository.save(cliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id,@RequestBody Cliente cliente){
		
		if(!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(id); // para forçar update e n criar novo usuario, setando o proprio parametro
		cliente = clienteRepository.save(cliente);
		
		return ResponseEntity.ok(cliente); 
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		if(!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		clienteRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
}
