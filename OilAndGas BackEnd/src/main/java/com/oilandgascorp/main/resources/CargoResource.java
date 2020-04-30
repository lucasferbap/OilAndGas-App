package com.oilandgascorp.main.resources;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.oilandgascorp.main.domain.Funcionario;
import com.oilandgascorp.main.dto.FuncionarioDTO;
import com.oilandgascorp.main.services.CargoService;

@RestController
@RequestMapping(value = "/cargos")
public class CargoResource {

	@Autowired
	private CargoService service;

	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<String>> getAllCargoNames(){
		return ResponseEntity.ok().body(service.findAllCargoNames()) ;
	}
	
}