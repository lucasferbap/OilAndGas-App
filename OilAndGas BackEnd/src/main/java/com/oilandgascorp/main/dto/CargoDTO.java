package com.oilandgascorp.main.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.oilandgascorp.main.domain.Cargo;

public class CargoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	@NotEmpty(message = "Por Favor entre com o nome")
	private String nome;
	
	public CargoDTO() {
	}

	public CargoDTO(Cargo cargo) {
		super();
		this.id = cargo.getId().toString();
		this.nome = cargo.getNome();
	}
	
	


	
}


