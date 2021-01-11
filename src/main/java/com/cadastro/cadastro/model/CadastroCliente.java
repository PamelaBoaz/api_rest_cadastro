package com.cadastro.cadastro.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_cadastro_cliente")
public class CadastroCliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 2, max = 50)
	private String nome;

	@Email
	@NotBlank
	private String email;
	@NotBlank
	@CPF
	private String cpf;

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_nascimento")
	private Date dataNascimento;

	public CadastroCliente() {
		super();
	}

	public CadastroCliente(@NotNull @Size(min = 2, max = 50) String nome, @Email @NotBlank String email,
			@NotBlank @CPF String cpf, @NotNull Date dataNascimento) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public CadastroCliente(Long id, @NotNull @Size(min = 2, max = 50) String nome, @Email @NotBlank String email,
			@NotBlank @CPF String cpf, @NotNull Date dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
