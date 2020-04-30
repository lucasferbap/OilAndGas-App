package com.oilandgascorp.main.services;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import com.oilandgascorp.main.domain.Cargo;
import com.oilandgascorp.main.domain.Empresa;
import com.oilandgascorp.main.domain.Funcionario;
import com.oilandgascorp.main.domain.Gerente;
import com.oilandgascorp.main.domain.enuns.EstadoFuncionario;
import com.oilandgascorp.main.dto.FuncionarioDTO;
import com.oilandgascorp.main.dto.FuncionarioNomeIdDTO;
import com.oilandgascorp.main.repositories.CargoRepository;
import com.oilandgascorp.main.repositories.EmbarqueRepository;
import com.oilandgascorp.main.repositories.EmpresaRepository;
import com.oilandgascorp.main.repositories.FuncionarioRepository;
import com.oilandgascorp.main.repositories.GerenteRepository;
import com.oilandgascorp.main.resources.CargoResource;
import com.oilandgascorp.main.resources.EmbarqueResource;
import com.oilandgascorp.main.resources.EmpresaResource;
import com.oilandgascorp.main.resources.FuncionarioResource;
import com.oilandgascorp.main.resources.GerenteResource;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private CargoRepository cargoRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private GerenteRepository gerenteRepository;

	@Autowired
	private EmbarqueRepository embarqueRepository;

	@Autowired
	private EmbarqueService embarqueService;

	// converte um funcionario dto em um funcionario;
	public Funcionario transformFuncionarioDtoIntoFuncionario(@Valid FuncionarioDTO funcionarioDto) {
		Cargo cargo = cargoRepository.findByNome(funcionarioDto.getCargo());
		Empresa empresa = empresaRepository.findByNome(funcionarioDto.getEmpresa());
		Gerente gerente = gerenteRepository.findByNome(funcionarioDto.getGerente());
		return new Funcionario(null, funcionarioDto.getNome(), funcionarioDto.getCpf(), cargo, empresa,
				EstadoFuncionario.descricaoToInteger(funcionarioDto.getEstadoFuncionario()), gerente);
	}

	// salva um funcionario no banco
	public void insertFuncionario(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}

	// paginação de funcionario dto com os links
	public Page<EntityModel<FuncionarioDTO>> findAllFuncionariosDTOPaged(String dataInicio, String dataFim,
			Integer page, Integer linesPerPage) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage);
		Page<Funcionario> funcionarios = dataInicio.isEmpty() ? funcionarioRepository.findAll(pageRequest)
				: funcionarioRepository.findAllComFiltroData(pageRequest, LocalDateTime.parse(dataInicio),
						LocalDateTime.parse(dataFim));
		Page<EntityModel<FuncionarioDTO>> FuncionarioDto = funcionarios.map(funcionario -> {
			return new EntityModel<FuncionarioDTO>(new FuncionarioDTO(funcionario),
					WebMvcLinkBuilder.linkTo(FuncionarioResource.class).slash(funcionario.getId()).withSelfRel(),
					WebMvcLinkBuilder.linkTo(GerenteResource.class).slash(funcionario.getGerente().getId())
							.withRel("Gerente"),
					WebMvcLinkBuilder.linkTo(EmbarqueResource.class).slash("/funcionarios/" + funcionario.getId())
							.withRel("Embarques"),
					WebMvcLinkBuilder.linkTo(CargoResource.class).slash("/" + funcionario.getCargo().getId())
							.withRel("Cargo"),
					WebMvcLinkBuilder.linkTo(EmpresaResource.class).slash(funcionario.getEmpresa().getId())
							.withRel("Empresa"));
		});
		return FuncionarioDto;
	}

	public Funcionario findById(Integer id) {
		return funcionarioRepository.findById(id).get();
	}

	public Page<FuncionarioNomeIdDTO> findAllFuncionarioNomeIdPaged(Integer page, Integer linesPerPage) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage);
		return funcionarioRepository.findAll(pageRequest).map(funcionario -> {
			return new FuncionarioNomeIdDTO(funcionario);
		});
	}


}
