package com.oilandgascorp.main.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.oilandgascorp.main.domain.Cargo;
import com.oilandgascorp.main.domain.Empresa;
import com.oilandgascorp.main.domain.Funcionario;
import com.oilandgascorp.main.domain.Gerente;
import com.oilandgascorp.main.domain.enuns.EstadoFuncionario;
import com.oilandgascorp.main.dto.FuncionarioDTO;
import com.oilandgascorp.main.repositories.CargoRepository;
import com.oilandgascorp.main.repositories.EmpresaRepository;
import com.oilandgascorp.main.repositories.FuncionarioRepository;
import com.oilandgascorp.main.repositories.GerenteRepository;

@Service
public class CargoService {


	
	@Autowired
	private CargoRepository cargoRepository;

	public List<String> findAllCargoNames() {
		return cargoRepository.findAllCargoName();
	}
	

	
	
	
	

}
