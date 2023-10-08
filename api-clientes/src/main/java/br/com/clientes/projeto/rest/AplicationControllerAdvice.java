package br.com.clientes.projeto.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import br.com.clientes.projeto.rest.exception.ApiErros;

@RestControllerAdvice
public class AplicationControllerAdvice {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErros handValidationExeptionErro(MethodArgumentNotValidException ex) {
		BindingResult bindingResult = ex.getBindingResult();
		List<String> menssagens = bindingResult.getAllErrors()
			.stream()
			.map(objectError -> objectError.getDefaultMessage())
			.collect(Collectors.toList());
		return new ApiErros(menssagens);
		
	}
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity handResponseStatusException(ResponseStatusException ex) {
		String menssagemError = ex.getMessage();
		HttpStatus codigoStatus = ex.getStatus();
		ApiErros apiErros = new ApiErros(menssagemError);
		return new ResponseEntity(apiErros, codigoStatus);
		
	}

}
