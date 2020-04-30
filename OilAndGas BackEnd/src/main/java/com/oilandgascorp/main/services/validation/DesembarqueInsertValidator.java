package com.oilandgascorp.main.services.validation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.oilandgascorp.main.domain.Embarque;
import com.oilandgascorp.main.dto.CadastroDesembarqueDTO;
import com.oilandgascorp.main.repositories.EmbarqueRepository;
import com.oilandgascorp.main.resources.exception.FieldMessage;
import com.oilandgascorp.main.services.EmbarqueService;

public class DesembarqueInsertValidator implements ConstraintValidator<DesembarqueInsert, CadastroDesembarqueDTO> {

	@Autowired
	private EmbarqueService embarqueService;

	@Override
	public void initialize(DesembarqueInsert ann) {
	}

	@Override
	public boolean isValid(CadastroDesembarqueDTO objDto, ConstraintValidatorContext context) {
		
		// mensagem padrao
		String msgPadrao = "O cadastro do desembarque não foi efetuado";

		Embarque embarque = embarqueService.findById(objDto.getIdEmbarque());
		
		LocalDateTime dataDesembarque =  LocalDateTime.parse(objDto.getDataDesembarque() + "T" + objDto.getHoraDesembarque());
		
		List<FieldMessage> listError = new ArrayList<>();
		
		//data escolhida é anterior a data de embarque
		if (dataDesembarque.isBefore(embarque.getDataEmbarque())) {
			listError.add(new FieldMessage("dataDesembarque",
					msgPadrao + ", a data escolhida é anterior a data de embarque"));
		}
		
		for (FieldMessage e : listError) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		return listError.isEmpty();
	}

}