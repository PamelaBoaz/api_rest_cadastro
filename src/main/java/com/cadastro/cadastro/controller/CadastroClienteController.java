package com.cadastro.cadastro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.cadastro.model.CadastroCliente;
import com.cadastro.cadastro.service.CadastroClienteService;

@RestController
@RequestMapping("/cadastro")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CadastroClienteController {

	@Autowired
	private CadastroClienteService cadastroClienteService;

	@PostMapping
	public ResponseEntity<CadastroCliente> post(@RequestBody @Valid CadastroCliente cadastro) {

		CadastroCliente cliente = cadastroClienteService.cadastrar(cadastro);
		if (cliente == null) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

}
