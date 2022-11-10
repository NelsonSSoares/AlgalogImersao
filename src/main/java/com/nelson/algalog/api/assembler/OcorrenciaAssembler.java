package com.nelson.algalog.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.nelson.algalog.api.model.Ocorrencia;
import com.nelson.algalog.api.model.OcorrenciaModel;

@Component
public class OcorrenciaAssembler {
	
	private ModelMapper modelMapper;
	
	
	
	public OcorrenciaAssembler(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}



	public OcorrenciaModel toModel(Ocorrencia ocorrencia) {
		return modelMapper.map(ocorrencia, OcorrenciaModel.class);
	}
	
	public List<OcorrenciaModel> toCollectionModel(List<Ocorrencia> ocorrencias){
		return ocorrencias.stream().map(this::toModel)
				.collect(Collectors.toList());
	}
}
