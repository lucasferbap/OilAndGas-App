package com.oilandgascorp.main.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oilandgascorp.main.domain.Embarque;
import com.oilandgascorp.main.services.validation.EmbarqueInsert;

@EmbarqueInsert
public class CadastroEmbarqueDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idFuncionario;
	
	@NotEmpty(message="A data de embarque não pode ser vazia, entre com uma data")
	private String dataEmbarque;
	
	@NotEmpty(message="A data de embarque não pode ser vazia, entre com uma hora")
	private String horaEmbarque;

	
	
	
	public CadastroEmbarqueDTO() {
	}
	
	public CadastroEmbarqueDTO(Integer idFuncionario, String dataEmbarque, String horaEmbarque) {
		super();
		this.idFuncionario = idFuncionario;
		this.dataEmbarque = dataEmbarque;
		this.horaEmbarque = horaEmbarque;
	}


	public String getDataEmbarque() {
		return this.dataEmbarque;
	}

	public void setDataEmbarque(String dataEmbarque) {
		this.dataEmbarque = dataEmbarque;
	}

	public String getHoraEmbarque() {
		return this.horaEmbarque;
	}

	public void setHoraEmbarque(String horaEmbarque) {
		this.horaEmbarque = horaEmbarque;
	}


	public Integer getIdFuncionario() {
		return this.idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	


	
}


