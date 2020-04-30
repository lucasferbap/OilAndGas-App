package com.oilandgascorp.main.resources;


import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.oilandgascorp.main.domain.Funcionario;
import com.oilandgascorp.main.dto.FuncionarioDTO;
import com.oilandgascorp.main.dto.FuncionarioNomeIdDTO;
import com.oilandgascorp.main.resources.utils.URL;
import com.oilandgascorp.main.services.EmbarqueService;
import com.oilandgascorp.main.services.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {

	@Autowired
	private FuncionarioService service;
	
	@Autowired
	private EmbarqueService embarqueService;
	
	

	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody FuncionarioDTO funcionarioDto){
		Funcionario funcionario = service.transformFuncionarioDtoIntoFuncionario(funcionarioDto);
		service.insertFuncionario(funcionario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(funcionario.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<EntityModel<FuncionarioDTO>>> findAllFuncionariosPaged(
			@RequestParam(value = "dataInicio", defaultValue = "") String inicio,
			@RequestParam(value = "dataFim", defaultValue = "") String fim,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage
			){
		return ResponseEntity.ok().body(service.findAllFuncionariosDTOPaged(URL.decodeParam(inicio), URL.decodeParam(fim), page, linesPerPage));
	} 
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FuncionarioDTO> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(new FuncionarioDTO(service.findById(id)));
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/nomes", method = RequestMethod.GET)
	public ResponseEntity<Page<FuncionarioNomeIdDTO>> findAllFuncionarioNomeIdPaged(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage
			){
		return ResponseEntity.ok().body(service.findAllFuncionarioNomeIdPaged(page, linesPerPage));
	}
	
}