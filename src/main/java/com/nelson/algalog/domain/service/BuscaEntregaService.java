package com.nelson.algalog.domain.service;

import com.nelson.algalog.api.model.Entrega;
import com.nelson.algalog.domain.exception.EntidadeNaoEncontradaException;
import com.nelson.algalog.domain.repository.EntregaRepository;

public class BuscaEntregaService {
	
	private EntregaRepository entregaRepository;
	
	
	
	public BuscaEntregaService(EntregaRepository entregaRepository) {
		super();
		this.entregaRepository = entregaRepository;
	}



	public Entrega buscar(Long entregaId, String descricao) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(()-> new EntidadeNaoEncontradaException("Entrega Não encontrada"));
	}
}
