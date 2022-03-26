package com.engrenelog.engrenemc.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.engrenelog.engrenemc.services.exceptions.AuthorizationException;
import com.engrenelog.engrenemc.services.exceptions.DataIntegrityException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e,HttpServletRequest request){	
		StandardError err = new StandardError(System.currentTimeMillis(),
				                HttpStatus.NOT_FOUND.value(),
				                "Não Encontrado",
				                e.getMessage(),
				                request.getRequestURI());
			
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
		
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e,HttpServletRequest request){	
		StandardError err = new StandardError(
				System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(),
                "Integridade de Dados",
                e.getMessage(),
                request.getRequestURI());		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e,HttpServletRequest request){	
		ValidationError err = new ValidationError(
				System.currentTimeMillis(),
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Erro de Validação",
                e.getMessage(),
                request.getRequestURI()
				);
				
				
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	
	}
	
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<StandardError> authorization(AuthorizationException e,HttpServletRequest request){	
		StandardError err = new StandardError(
				System.currentTimeMillis(),
                HttpStatus.FORBIDDEN.value(),
                "Acesso Negado!",
                e.getMessage(),
                request.getRequestURI());
		
		//FORBIDDEN é o código http aceso negado.
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
	}
}
	
	
