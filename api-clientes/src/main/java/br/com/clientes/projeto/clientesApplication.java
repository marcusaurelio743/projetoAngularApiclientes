package br.com.clientes.projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.clientes.projeto.model.Cliente;
import br.com.clientes.projeto.repository.ClienteRepository;

@SpringBootApplication
public class clientesApplication {
	
	@Bean
	public CommandLineRunner run( @Autowired ClienteRepository repository) {
		return args ->{
			Cliente cliente = new Cliente();
			
			cliente.setCpf("20393874834783");
			cliente.setNome("fulano de Tal pereira");
			repository.save(cliente);
			
			System.out.println(cliente);
			
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(clientesApplication.class, args);
	}

}
