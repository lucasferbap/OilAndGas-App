package com.oilandgascorp.main.services.validation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.oilandgascorp.main.domain.Embarque;
import com.oilandgascorp.main.dto.CadastroEmbarqueDTO;
import com.oilandgascorp.main.resources.exception.FieldMessage;
import com.oilandgascorp.main.services.EmbarqueService;

public class EmbarqueInsertValidator implements ConstraintValidator<EmbarqueInsert, CadastroEmbarqueDTO> {

	@Autowired
	private EmbarqueService embarqueService;

	@Override
	public void initialize(EmbarqueInsert ann) {
	}

	@Override
	public boolean isValid(CadastroEmbarqueDTO objDto, ConstraintValidatorContext context) {

		List<FieldMessage> listError = new ArrayList<>();

		// parse das datas de embarque e desembarques vindas do objdto
		LocalDateTime dataEmbarque = LocalDateTime.parse(objDto.getDataEmbarque() + "T" + objDto.getHoraEmbarque());

		// carregando a lista de embarques do funcionario
		List<Embarque> embarques = embarqueService.findAllEmbarquesPorFuncionarioList(objDto.getIdFuncionario());

		// mensagem padrao
		String msgPadrao = "O cadastro do embarque não foi efetuado";

		if (embarques.size() != 0) {
			// Primeiro erro: se o funcionario estiver com um embarque com a data de
			// desembarque pendente, nao pode embarcar
			if (embarques.get(embarques.size() - 1).getDataDesembarque() == null) {
				listError.add(new FieldMessage("dataEmbarque", msgPadrao
						+ ", por favor cadastre o desembarque do funcíonario antes de cadastrar um novo embarque"));
			} else {
				// Segundo Erro : se a data for antes da data de hoje
				if (dataEmbarque.isBefore(LocalDateTime.now())) {
					listError.add(new FieldMessage("dataEmbarque",
							msgPadrao + ", a data escolhida é anterior a data de hoje"));

					// Terceiro erro : se a data coincidir com algum outro embarque
					for (Embarque e : embarques) {
						if (dataEmbarque.isAfter(e.getDataEmbarque())
								&& dataEmbarque.isBefore(e.getDataDesembarque())) {
							listError.add(new FieldMessage("dataEmbarque",
									msgPadrao + ", a data escolhida é durante ao período de embarque. id do embarque : "
											+ e.getId()));
						}
					}
				}

			}
		}else {
			// Segundo Erro : se a data for antes da data de hoje
			if (dataEmbarque.isBefore(LocalDateTime.now())) {
				listError.add(new FieldMessage("dataEmbarque",
						msgPadrao + ", a data escolhida é anterior a data de hoje"));

				// Terceiro erro : se a data coincidir com algum outro embarque
				for (Embarque e : embarques) {
					if (dataEmbarque.isAfter(e.getDataEmbarque())
							&& dataEmbarque.isBefore(e.getDataDesembarque())) {
						listError.add(new FieldMessage("dataEmbarque",
								msgPadrao + ", a data escolhida é durante ao período de embarque. id do embarque : "
										+ e.getId()));
					}
				}
			}
		}

		for (FieldMessage e : listError) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return listError.isEmpty();
	}

}