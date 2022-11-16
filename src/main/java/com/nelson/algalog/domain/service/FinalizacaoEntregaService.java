package com.nelson.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nelson.algalog.api.model.Entrega;
import com.nelson.algalog.domain.repository.EntregaRepository;

@Service
public class FinalizacaoEntregaService {

	
	
	private EntregaRepository entregaRepository;
	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public void finalizar(Long entregaId) {
		
		Entrega entrega = buscaEntregaService.buscar(entregaId, "");
		entrega.finalizar();
		entregaRepository.save(entrega);
		
	}
	
}
