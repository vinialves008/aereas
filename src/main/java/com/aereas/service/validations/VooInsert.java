package com.aereas.service.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = VooInsertValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface VooInsert {

	String message() default "Erro de Validação";
	Class<?> [] groups() default {};
	Class<? extends Payload> [] payload() default {};
	
}
