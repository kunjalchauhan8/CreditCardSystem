package com.creditcard.system.validator;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LuhnValidator implements ConstraintValidator<LuhnConstraint, Long> {

	@Override
	public void initialize(LuhnConstraint cardNumber) {
	}

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		return Objects.nonNull(value) ? checkLuhn(String.valueOf(value)) : false;
	}

	private boolean checkLuhn(String cardNo) {
		int nDigits = cardNo.length();

		int nSum = 0;
		boolean isSecond = false;
		for (int i = nDigits - 1; i >= 0; i--) {

			int d = cardNo.charAt(i) - '0';

			if (isSecond == true)
				d = d * 2;

			// We add two digits to handle
			// cases that make two digits
			// after doubling
			nSum += d / 10;
			nSum += d % 10;

			isSecond = !isSecond;
		}
		return (nSum % 10 == 0);
	}

}
