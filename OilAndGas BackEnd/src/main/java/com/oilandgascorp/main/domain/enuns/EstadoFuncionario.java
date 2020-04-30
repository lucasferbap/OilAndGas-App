package com.oilandgascorp.main.domain.enuns;

public enum EstadoFuncionario {
	EMBARCADO(1, "Embarcado"), DESEMBARCADO(2, "Desembarcado");

	private int cod;
	private String descricao;

	private EstadoFuncionario(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EstadoFuncionario toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (EstadoFuncionario x : EstadoFuncionario.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inv�lido: " + cod);
	}
	
	public static Integer descricaoToInteger(String descricao) {
		return descricao.toUpperCase() == "EMBARCADO" ? 1 : 2;
	}
}
