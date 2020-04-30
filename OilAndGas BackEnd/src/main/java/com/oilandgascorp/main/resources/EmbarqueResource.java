package com.oilandgascorp.main.resources;

import java.net.URI;

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

import com.oilandgascorp.main.domain.Embarque;
import com.oilandgascorp.main.dto.CadastroDesembarqueDTO;
import com.oilandgascorp.main.dto.CadastroEmbarqueDTO;
import com.oilandgascorp.main.dto.EmbarqueDTO;
import com.oilandgascorp.main.services.EmbarqueService;

@RestController
@RequestMapping(value = "/embarques")
public class EmbarqueResource {

	
	@Autowired
	private EmbarqueService service;

	// busca paginada de todos os embarques de um funcionario
	@CrossOrigin
	@RequestMapping(value = "/funcionarios/{id}", method = RequestMethod.GET)
	public ResponseEntity<Page<EmbarqueDTO>> getAllEmbarquesPorFuncionarioPaged(
			@PathVariable Integer id,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage
			){
		return ResponseEntity.ok().body(service.findAllEmbarquesPorFuncionarioPaged(page, linesPerPage, id)) ;
	}
	
	// cadastrando um embarque
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insertEmbarque(@Valid @RequestBody CadastroEmbarqueDTO objDto) {
		Embarque embarque = service.insertEmbarque(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(embarque.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	// atualizando o embarque (desembarcando um funcionario)
	@CrossOrigin
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> updateEmbarque(@Valid @RequestBody CadastroDesembarqueDTO objDto, @PathVariable Integer id) {
		service.updateEmbarque(objDto);
		return ResponseEntity.noContent().build();
	}
}
