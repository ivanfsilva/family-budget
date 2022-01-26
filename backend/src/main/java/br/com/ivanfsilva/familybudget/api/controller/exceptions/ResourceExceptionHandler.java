package br.com.ivanfsilva.familybudget.api.controller.exceptions;

import br.com.ivanfsilva.familybudget.domain.service.exceptions.DatabaseException;
import br.com.ivanfsilva.familybudget.domain.service.exceptions.ReceitaExistenteException;
import br.com.ivanfsilva.familybudget.domain.service.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError error = new StandardError();
		infoErrors(error, status, "Recurso não encontrado", e.getMessage(), request);

		return ResponseEntity.status(status).body(error);
	}

	@ExceptionHandler(ReceitaExistenteException.class)
	public ResponseEntity<StandardError> resourceFound(ReceitaExistenteException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.FOUND;

		StandardError error = new StandardError();
		infoErrors(error, status, "Lançamento Encontrado", e.getMessage(), request);

		return ResponseEntity.status(status).body(error);
	}

	@ExceptionHandler({DatabaseException.class})
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		StandardError error = new StandardError();
		infoErrors(error, status, "Violação de integridade", e.getMessage(), request);

		return ResponseEntity.status(status).body(error);
	}

	@ExceptionHandler({MethodArgumentNotValidException.class})
	public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

		ValidationError error = new ValidationError();
		infoErrors(error, status, "Validation Exception", e.getMessage(), request);

		for (FieldError f : e.getBindingResult().getFieldErrors()) {
			error.addError(f.getField(), f.getDefaultMessage());
		}

		return ResponseEntity.status(status).body(error);
	}

	private void infoErrors(StandardError error, HttpStatus status, String mensagem, String e, HttpServletRequest request) {
		error.setTimeStamp(Instant.now());
		error.setStatus(status.value());
		error.setError(mensagem);
		error.setMessage(e);
		error.setPath(request.getRequestURI());
	}
}
