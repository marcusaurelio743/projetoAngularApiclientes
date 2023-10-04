package br.com.clientes.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clientes.projeto.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
