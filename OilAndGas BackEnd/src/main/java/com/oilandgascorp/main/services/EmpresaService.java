package com.oilandgascorp.main.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.oilandgascorp.main.domain.Cargo;
import com.oilandgascorp.main.domain.Empresa;
import com.oilandgascorp.main.domain.Funcionario;
import com.oilandgascorp.main.domain.Gerente;
import com.oilandgascorp.main.domain.enuns.EstadoFuncionario;
import com.oilandgascorp.main.dto.EmpresaDTO;
import com.oilandgascorp.main.dto.FuncionarioDTO;
import com.oilandgascorp.main.repositories.CargoRepository;
import com.oilandgascorp.main.repositories.EmpresaRepository;
import com.oilandgascorp.main.repositories.FuncionarioRepository;
import com.oilandgascorp.main.repositories.GerenteRepository;

@Service
public class EmpresaService {


	
	@Autowired
	private EmpresaRepository empresaRepository;

	public List<String> findAllEmpresasNames() {
		return empresaRepository.findAllEmpresaName();
	}

	public void insertEmpresa(@Valid Empresa empresa) {
		empresaRepository.save(empresa);
		
	}

	public Page<EmpresaDTO> getAllEmpresas(Integer page, Integer linesPerPage) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage);
		return empresaRepository.findAll(pageRequest).map( empresa -> new EmpresaDTO(empresa));
	}
	

	
	
	
	

}
