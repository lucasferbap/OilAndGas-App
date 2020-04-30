package com.oilandgascorp.main.services;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.oilandgascorp.main.domain.Embarque;
import com.oilandgascorp.main.dto.CadastroDesembarqueDTO;
import com.oilandgascorp.main.dto.CadastroEmbarqueDTO;
import com.oilandgascorp.main.dto.EmbarqueDTO;
import com.oilandgascorp.main.repositories.EmbarqueRepository;

@Service
public class EmbarqueService {

	@Autowired
	EmbarqueRepository embarqueRepository;

	@Autowired
	FuncionarioService funcionarioService;

	public Page<EmbarqueDTO> findAllEmbarquesPorFuncionarioPaged(Integer page, Integer linesPerPage,
			Integer idFuncionario) {
		Pageable pageRequest = PageRequest.of(page, linesPerPage);
		return embarqueRepository.findAllPaged(pageRequest, idFuncionario).map(obj -> new EmbarqueDTO(obj));
	}

	public List<Embarque> findAllEmbarquesPorFuncionarioList(Integer id) {
		return embarqueRepository.findAllList(id);
	}

	public Embarque insertEmbarque(@Valid CadastroEmbarqueDTO objDto) {
		Embarque embarque = new Embarque(null,
				LocalDateTime.parse(objDto.getDataEmbarque() + "T" + objDto.getHoraEmbarque()),
				funcionarioService.findById(objDto.getIdFuncionario()));
		return embarqueRepository.save(embarque);
	}

	public void updateEmbarque(@Valid CadastroDesembarqueDTO objDto) {
		Embarque embarque = embarqueRepository.findById(objDto.getIdEmbarque()).get();
		embarque.setDataDesembarque(LocalDateTime.parse(objDto.getDataDesembarque() + "T" + objDto.getHoraDesembarque()));
		embarqueRepository.save(embarque);
	}
	
	public Embarque findById(Integer id) {
		return embarqueRepository.findById(id).get();
	}
}
