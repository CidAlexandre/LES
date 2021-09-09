package com.pethouse.api.exceptionhandler;

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

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<Problems.Fields> field = new ArrayList<>();
		
		
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String name = ((FieldError)error).getField();
			String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			
			field.add(new Problems.Fields(name, message));
		}
		
		Problems p = new Problems();
		p.setStatus(status.value());
		p.setDataHora(LocalDateTime.now());
		p.setTittle("Um ou mais campos inválidos. Faça o preenchimento correto e tente novamente.");
		p.setFields(field);  
		
		return handleExceptionInternal(ex, p , headers, status, request);
	}
	
}
