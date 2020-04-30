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

public class FuncionarioNomeIdDTO extends RepresentationModel implements Serializable {



	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Por Favor entre com o nome")
	private String nome;


	public FuncionarioNomeIdDTO(){}
	
	// construtor geral
	public FuncionarioNomeIdDTO(Funcionario funcionario) {
		this.id = funcionario.getId();
		this.nome = funcionario.getNome();
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



	
	

}
