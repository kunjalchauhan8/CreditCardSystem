package com.creditcard.system.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;

@Documented
@Constraint(validatedBy = LuhnValidator.class)
@java.lang.annotation.Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface LuhnConstraint {

	String message() default "CreditCard is not Valid";

	Class<?>[] groups() default {};

	Class<? extends Package>[] payload() default {};

}
