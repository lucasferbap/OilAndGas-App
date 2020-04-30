package com.oilandgascorp.main.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oilandgascorp.main.resources.utils.URL;
import com.oilandgascorp.main.services.GerenteService;

@RestController
@RequestMapping(value = "/gerentes")
public class GerenteResource {

	@Autowired
	private GerenteService service;

	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<String>> findAllGerentesNamesPorEmpresa(@RequestParam(value = "nomeEmpresa", defaultValue = "") String nomeEmpresa){
		System.out.println(URL.decodeParam(nomeEmpresa));
		return ResponseEntity.ok().body(service.findAllGerentesNamesPorEmpresa(URL.decodeParam(nomeEmpresa)));
	}
	
}