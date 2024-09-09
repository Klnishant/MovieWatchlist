package com.example.watchlist.models.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RatingAnotationLogic.class)
public @interface Rating {
	
	String message() default "Please Enter Rating between 5 and 10";
	
	Class<?>[]groups() default {};
	Class<? extends Payload>[] payload() default {};
}
