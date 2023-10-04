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
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(clientesApplication.class, args);
	}

}
