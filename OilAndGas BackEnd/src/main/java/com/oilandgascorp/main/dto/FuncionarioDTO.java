package com.oilandgascorp.main.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.domain.Page;
import org.springframework.hateoas.RepresentationModel;

import com.oilandgascorp.main.domain.Funcionario;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class FuncionarioDTO extends RepresentationModel implements Serializable {



	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Por Favor entre com o nome")
	private String nome;
	
	@NotEmpty(message = "Por Favor entre com o CPF")
	private String cpf;
	
	@NotEmpty(message = "Por Favor entre com o cargo")
	private String cargo;
	
	@NotEmpty(message = "Por Favor entre com o empresa")
	private String empresa;
	
	@NotEmpty(message = "Por Favor entre com o gerente")
	private String gerente;
	
	private String estadoFuncionario;

	public FuncionarioDTO(){}
	
	// construtor geral
	public FuncionarioDTO(Funcionario funcionario) {
		this.id = funcionario.getId();
		this.nome = funcionario.getNome();
		this.cpf = funcionario.getCpf();
		this.cargo = funcionario.getCargo().getNome();
		this.empresa = funcionario.getEmpresa().getNome();
		this.gerente = funcionario.getGerente().getNome();
		this.estadoFuncionario = funcionario.getEstado().getDescricao();
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	public String getGerente() {
		return gerente;
	}


	public void setGerente(String gerente) {
		this.gerente = gerente;
	}


	public String getEstadoFuncionario() {
		return estadoFuncionario;
	}


	public void setEstadoFuncionario(String estadoFuncionario) {
		this.estadoFuncionario = estadoFuncionario;
	}

	
	

}
