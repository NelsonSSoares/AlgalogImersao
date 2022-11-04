package com.nelson.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nelson.algalog.api.model.Cliente;
import com.nelson.algalog.domain.exception.NegocioException;
import com.nelson.algalog.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor //contrutor com lombok
@Service //torna a classe um compenente do spring com semantica de servico do spring que representa os servicos que serao executados regra de negocio
public class CatalogoClienteService {

	private ClienteRepository clienteRepository;
	
	
	@Transactional // declara metodo deve ser executado dentro de uma transação ou seja algo que der errado todas as operações da transação no banco é descartado
	public Cliente salvar(Cliente cliente) {
				
				//verificação para checar se email esta em uso
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if(emailEmUso) { 
			throw new NegocioException("Ja Existe Cliente Cadastrado com este Email");
		}
		
		return clienteRepository.save(cliente);
	}
	@Transactional
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
	
}
