package com.cadastro.cadastro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.cadastro.model.CadastroCliente;
import com.cadastro.cadastro.repository.CadastroClienteRepository;

@Service
public class CadastroClienteService {

	@Autowired
	private CadastroClienteRepository repository;

	public CadastroCliente Cadastro(CadastroCliente cadastro) {
		Optional<CadastroCliente> cpfExistente = repository.findByCpf(cadastro.getCpf());

		Optional<CadastroCliente> emailExistente = repository.findByEmail(cadastro.getEmail());

		if (cpfExistente.isPresent() || emailExistente.isPresent()) {
			return null;
		}
		return repository.save(cadastro);
	}

}
