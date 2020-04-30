package com.oilandgascorp.main.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.oilandgascorp.main.domain.enuns.EstadoFuncionario;

@Entity
@PrimaryKeyJoinColumn(name = "id_funcionario")
public class Funcionario extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer estadoFuncionario;

	@ManyToOne(cascade = CascadeType.MERGE)

	private Gerente gerente;

	@OneToMany(cascade = CascadeType.MERGE)

	private List<Embarque> embarques = new ArrayList<>();

	public Funcionario() {
	}

	

	public Funcionario(Integer id, @NotEmpty(message = "Por Favor entre com o nome") String nome,
			@NotEmpty(message = "Por Favor entre com o CPF") String cpf, @NotEmpty Cargo cargo,
			@NotEmpty Empresa empresa, Integer estadoFuncionario, Gerente gerente) {
		super(id, nome, cpf, cargo, empresa);
		this.estadoFuncionario = estadoFuncionario;
		this.gerente = gerente;
	}



	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public List<Embarque> getEmbarques() {
		return embarques;
	}

	public void setEmbarques(List<Embarque> embarques) {
		this.embarques = embarques;
	}

	public EstadoFuncionario getEstado() {
		return EstadoFuncionario.toEnum(this.estadoFuncionario);
	}

	public void setEstado(Integer estadoFuncionario) {
		this.estadoFuncionario = estadoFuncionario;
		
	}

}
