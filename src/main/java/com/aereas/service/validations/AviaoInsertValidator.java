package com.aereas.service.validations;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.aereas.domain.dto.AviaoNewDTO;
import com.aereas.service.AviaoService;
import com.aereas.service.exceptions.FieldMessage;

public class AviaoInsertValidator implements ConstraintValidator<AviaoInsert, AviaoNewDTO> {

	@Autowired
	private AviaoService service;

	@Override
	public void initialize(AviaoInsert constraintAnnotation) {
	}

	@Override
	public boolean isValid(AviaoNewDTO value, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

		Boolean isModel = service.findByModelo(value.getModelo());
		if (isModel) {
			list.add(new FieldMessage("modelo", "Você já possui um modelo com este nome"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
