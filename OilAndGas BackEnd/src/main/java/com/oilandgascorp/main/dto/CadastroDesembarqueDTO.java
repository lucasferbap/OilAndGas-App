package com.oilandgascorp.main.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.oilandgascorp.main.services.validation.DesembarqueInsert;

@DesembarqueInsert
public class CadastroDesembarqueDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idEmbarque;
	
	@NotEmpty(message="A data de desembarque não pode ser vazia, entre com uma hora")
	private String dataDesembarque;
	
	@NotEmpty(message="A data de desembarque não pode ser vazia, entre com uma hora")
	private String horaDesembarque;
	
	
	
	public CadastroDesembarqueDTO() {
	}
	
	public CadastroDesembarqueDTO( String dataDesembarque, String horaDesembarque) {
		super();
		this.dataDesembarque = dataDesembarque;
		this.horaDesembarque = horaDesembarque;
	}

	public String getDataDesembarque() {
		return dataDesembarque;
	}

	public void setDataDesembarque(String dataDesembarque) {
		this.dataDesembarque = dataDesembarque;
	}

	public String getHoraDesembarque() {
		return horaDesembarque;
	}

	public void setHoraDesembarque(String horaDesembarque) {
		this.horaDesembarque = horaDesembarque;
	}

	public Integer getIdEmbarque() {
		return idEmbarque;
	}

	public void setIdEmbarque(Integer idEmbarque) {
		this.idEmbarque = idEmbarque;
	}

	


	
}


