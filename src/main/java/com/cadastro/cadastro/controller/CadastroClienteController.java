package com.cadastro.cadastro.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.cadastro.model.CadastroCliente;
import com.cadastro.cadastro.repository.CadastroClienteRepository;
import com.cadastro.cadastro.service.CadastroClienteService;

@RestController
@RequestMapping("/cadastro")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CadastroClienteController {

	@Autowired
	private CadastroClienteService cadastroClienteService;

	@Autowired
	private CadastroClienteRepository repository;

	@PostMapping
	public ResponseEntity<CadastroCliente> post(@RequestBody @Valid CadastroCliente cadastro) {

		CadastroCliente cliente = cadastroClienteService.cadastrar(cadastro);
		if (cliente == null) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@GetMapping
	public ResponseEntity<List<CadastroCliente>> findAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CadastroCliente> findById(@PathVariable Long id) {
		Optional<CadastroCliente> clientecadastrado = repository.findById(id);
		if (clientecadastrado.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(clientecadastrado.get());
	}

	@PutMapping
	public ResponseEntity<CadastroCliente> alter(@RequestBody CadastroCliente clientecadastrado) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(clientecadastrado));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
