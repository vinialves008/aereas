package com.aereas.service.validations;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.aereas.domain.Aviao;
import com.aereas.domain.Voo;
import com.aereas.domain.dto.VooNewDTO;
import com.aereas.service.AviaoService;
import com.aereas.service.VooService;
import com.aereas.service.exceptions.FieldMessage;

public class VooInsertValidator implements ConstraintValidator<VooInsert, VooNewDTO> {

	@Autowired
	private VooService service;

	@Autowired
	private AviaoService aviaoService;

	@Override
	public void initialize(VooInsert constraintAnnotation) {
	}

	@Override
	public boolean isValid(VooNewDTO value, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

		Aviao aviao = aviaoService.findById(value.getAviao());

		Voo voo = service.findByVoo(aviao, value.getEmbarque(), value.getChegada());

		if (voo == null) {
			Voo voo2 = service.findByAviaoAndStartDateBetween(aviao, value.getEmbarque(), value.getChegada());
			if (voo2 != null) {
				list.add(new FieldMessage("aviao", "Você já possui um Voo cadastrado para este avião"));
			}
		} else {
			list.add(new FieldMessage("aviao", "Este Voo já está cadastrado!"));
		}

		if (value.getChegada().before(value.getEmbarque())) {
			list.add(new FieldMessage("embarque", "O horário de Embarque precisa ser anterior ao de Chegada."));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
