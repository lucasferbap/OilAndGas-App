package com.oilandgascorp.main.resources;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.oilandgascorp.main.domain.Empresa;
import com.oilandgascorp.main.dto.EmpresaDTO;
import com.oilandgascorp.main.services.EmpresaService;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaResource {

	@Autowired
	private EmpresaService service;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<EmpresaDTO>> getAllEmpresas(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "2") Integer linesPerPage
			){
		return ResponseEntity.ok().body(service.getAllEmpresas(page, linesPerPage)) ;
	}

	
	@CrossOrigin
	@RequestMapping(value="/nomes", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getAllEmpresasNames(){
		return ResponseEntity.ok().body(service.findAllEmpresasNames()) ;
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insertEmpresa(@Valid @RequestBody Empresa empresa){
		service.insertEmpresa(empresa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(empresa.getId()).toUri();
			return ResponseEntity.created(uri).build();
	}
	
}