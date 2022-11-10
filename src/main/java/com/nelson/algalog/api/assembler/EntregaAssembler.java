package com.nelson.algalog.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.nelson.algalog.api.model.Entrega;
import com.nelson.algalog.api.model.EntregaModel;
import com.nelson.algalog.api.model.input.EntregaInput;


//@AllArgsConstructor
@Component
public class EntregaAssembler {
	
	
	
	public EntregaAssembler(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}

	private ModelMapper modelMapper;
	
	public EntregaModel toModel(Entrega entrega) {
		return modelMapper.map(entrega, EntregaModel.class);
	}
	
	public List<EntregaModel> toCollectionModel(List<Entrega> entregas){
		return entregas.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	public Entrega toEntity(EntregaInput entregaInput ) {
		return modelMapper.map(entregaInput, Entrega.class);
	}
}
