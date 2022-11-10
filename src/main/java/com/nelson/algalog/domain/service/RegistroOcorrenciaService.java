package com.nelson.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nelson.algalog.api.model.Entrega;
import com.nelson.algalog.api.model.Ocorrencia;


@Service
public class RegistroOcorrenciaService {
	
	private BuscaEntregaService buscaEntregaService;
	
	
	


	public RegistroOcorrenciaService(BuscaEntregaService buscaEntregaService) {
		super();
		this.buscaEntregaService = buscaEntregaService;
	}





	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
		 
		Entrega entrega = buscaEntregaService.buscar(entregaId, descricao);
		
		return entrega.adicionarOcorrencia(descricao);
	}
	
	
}
