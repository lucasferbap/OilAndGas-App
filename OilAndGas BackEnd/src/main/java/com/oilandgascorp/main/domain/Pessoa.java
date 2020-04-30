package com.oilandgascorp.main.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Pessoa extends RepresentationModel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Por Favor entre com o nome")
	@Column(unique=true)
	private String nome;
	
	@NotEmpty(message = "Por Favor entre com o CPF")
	@Column(unique=true)
	private String cpf;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Cargo cargo;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Empresa empresa;

	public Pessoa() {
	}


	public Pessoa(Integer id, @NotEmpty(message = "Por Favor entre com o nome") String nome,
			@NotEmpty(message = "Por Favor entre com o CPF") String cpf, Cargo cargo, Empresa empresa) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
		this.empresa = empresa;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	

}
