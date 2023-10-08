package br.com.clientes.projeto.rest.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class ApiErros {
	@Getter
		private List<String> errors;
	
	public ApiErros(List<String> erros) {
		this.errors = erros;
	}
	
	public ApiErros(String message) {
		this.errors = Arrays.asList(message);
	}
}
