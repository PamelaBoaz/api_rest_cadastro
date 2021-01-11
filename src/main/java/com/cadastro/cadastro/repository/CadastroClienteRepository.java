package com.cadastro.cadastro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cadastro.cadastro.model.CadastroCliente;

@Repository
public interface CadastroClienteRepository extends JpaRepository<CadastroCliente, Long> {

	public Optional<CadastroCliente> findByCpf(String cpf);

	public Optional<CadastroCliente> findByEmail(String email);

}
