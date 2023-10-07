package br.com.clientes.projeto.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.clientes.projeto.model.Cliente;
import br.com.clientes.projeto.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvar( @RequestBody @Valid Cliente cliente) {
		return repository.save(cliente);
	}
	
	
	@GetMapping("{id}")
	public Cliente buscaPorId(@PathVariable Long id) {
		return repository.
				findById(id).
				//expresão ororElseThrow e se caso não achar retorna esse erro
				orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void Deletar(@PathVariable Long id) {
		 repository.
				findById(id).
				map(cliente->{
					repository.delete(cliente);
					return Void.TYPE;
				})
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Long id,@RequestBody @Valid Cliente clienteAtualizado) {
		repository.
				findById(id).
					map(cliente->{
						clienteAtualizado.setId(cliente.getId());
						clienteAtualizado.setDataCadastro(cliente.getDataCadastro());
						
						return repository.save(clienteAtualizado);
					})
					.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
		
	}

}
