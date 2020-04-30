package com.oilandgascorp.main.dto;

import java.io.Serializable;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oilandgascorp.main.domain.Embarque;

public class EmbarqueDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idEmbarque;
	private Integer idFuncionario;
	private String dataEmbarque;
	private String horaEmbarque;
	private String dataDesembarque;
	private String horaDesembarque;
	
	public EmbarqueDTO() {
	}
	
	public EmbarqueDTO(Embarque embarque) {
		this.idEmbarque = embarque.getId();
		this.idFuncionario = embarque.getFuncionario().getId();
		this.dataEmbarque = "" + embarque.getDataEmbarque().getDayOfMonth() + "/" + embarque.getDataEmbarque().getMonth() + "/" + embarque.getDataEmbarque().getYear();
		this.horaEmbarque = "" + embarque.getDataEmbarque().getHour() + ":" + embarque.getDataEmbarque().getMinute() + ":" + embarque.getDataEmbarque().getSecond();
		if(embarque.getDataDesembarque() != null) {
			this.dataDesembarque = "" + embarque.getDataDesembarque().getDayOfMonth() + "/" + embarque.getDataDesembarque().getMonth() + "/" + embarque.getDataDesembarque().getYear();
			this.horaDesembarque = "" + embarque.getDataDesembarque().getHour() + ":" + embarque.getDataDesembarque().getMinute() + ":" + embarque.getDataDesembarque().getSecond();
		}
		
	}

	public Integer getIdEmbarque() {
		return idEmbarque;
	}

	public void setIdEmbarque(Integer idEmbarque) {
		this.idEmbarque = idEmbarque;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getDataEmbarque() {
		return dataEmbarque;
	}

	public void setDataEmbarque(String dataEmbarque) {
		this.dataEmbarque = dataEmbarque;
	}

	public String getHoraEmbarque() {
		return horaEmbarque;
	}

	public void setHoraEmbarque(String horaEmbarque) {
		this.horaEmbarque = horaEmbarque;
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

	


	
}


