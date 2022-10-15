package com.nelson.algalog.api.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;




//ResponseEntityExceptionHandler classe que trata exceptions, devolve somente status http, não o stacktrace do error
@ControllerAdvice // A classe é um componente com proposito especifico para tratar exceções de controladores de forma global 
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	
	
	
	@Override // sobre escreve metodo de exception para um personalizando
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
			
		Problema problema = new Problema();
		
		List<Problema.Campo> campos = new ArrayList<>();
		
		for(ObjectError error : ex.getBindingResult().getAllErrors()) {
			
			String nome = ((FieldError)error).getField();
			String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale()); // pega messagem personalizada em messages.properties
			
			
			campos.add(new Problema.Campo(nome,mensagem));
		}
		
		problema.setStatus(status.value());
		problema.setDate(LocalDateTime.now());
		problema.setTitulo("Um ou mais campos estão invalidos");
		problema.setCampos(campos);
		
		return handleExceptionInternal(ex, problema, headers, status, request);
	}
	
}
