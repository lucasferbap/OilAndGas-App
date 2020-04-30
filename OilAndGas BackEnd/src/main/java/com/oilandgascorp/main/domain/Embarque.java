package com.oilandgascorp.main.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Embarque extends RepresentationModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 300)
	private LocalDateTime dataEmbarque;

	@Column(length = 300)
	private LocalDateTime dataDesembarque;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnore
	private Funcionario funcionario;

	public Embarque() {
	}

	public Embarque(Integer id, LocalDateTime dataEmbarque, Funcionario funcionario) {
		super();
		this.id = id;
		this.dataEmbarque = dataEmbarque;
		this.funcionario = funcionario;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataEmbarque() {
		return dataEmbarque;
	}

	public void setDataEmbarque(LocalDateTime dataEmbarque) {
		this.dataEmbarque = dataEmbarque;
	}

	public LocalDateTime getDataDesembarque() {
		return dataDesembarque;
	}

	public void setDataDesembarque(LocalDateTime dataDesembarque) {
		this.dataDesembarque = dataDesembarque;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
