package br.com.clientes.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clientes.projeto.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
