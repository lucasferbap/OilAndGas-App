package com.oilandgascorp.main.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@PrimaryKeyJoinColumn(name = "id_gerente")
public class Gerente extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToMany(cascade = CascadeType.MERGE)
	private List<Funcionario> funcionariosGerenciados = new ArrayList<>();
	

	public Gerente() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Gerente(Integer id, @NotEmpty(message = "Por Favor entre com o nome") String nome,
			@NotEmpty(message = "Por Favor entre com o CPF") String cpf, @NotEmpty Cargo cargo,
			@NotEmpty Empresa empresa) {
		super(id, nome, cpf, cargo, empresa);
		// TODO Auto-generated constructor stub
	}



	@JsonIgnore
	public List<Funcionario> getFuncionariosGerenciados() {
		return funcionariosGerenciados;
	}

	public void setFuncionariosGerenciados(List<Funcionario> funcionariosGerenciados) {
		this.funcionariosGerenciados = funcionariosGerenciados;
	}
	
	
}
