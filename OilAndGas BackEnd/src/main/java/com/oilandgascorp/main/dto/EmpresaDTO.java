package com.oilandgascorp.main.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.oilandgascorp.main.domain.Empresa;

public class EmpresaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	@NotEmpty(message = "Por Favor entre com o cnpj")
	private String cnpj;
	
	@NotEmpty(message = "Por Favor entre com o nome")
	private String nome;
	
	public EmpresaDTO() {
	}

	public EmpresaDTO(Empresa empresa) {
		super();
		this.id = empresa.getId().toString();
		this.cnpj = empresa.getCnpj();
		this.nome = empresa.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	


	
}


