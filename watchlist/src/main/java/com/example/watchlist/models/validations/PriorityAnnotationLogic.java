package com.example.watchlist.models.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PriorityAnnotationLogic implements ConstraintValidator<Priority, String>  {
	
	@Override	
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		return value.trim().length() == 1 && "LHM".contains(value.trim());
	}
}
