package br.com.caelum.vraptor.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.caelum.vraptor.validator.annotation.MinDouble;

public class MinDoubleValidator implements ConstraintValidator<MinDouble, Object>{
	private double minValue;

	@Override
	public void initialize(MinDouble minValue) {
		this.minValue = minValue.value();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if(value == null){
			return false;
		} else if(value instanceof Double){
			Double double1 = new Double(value.toString());
			return double1 > minValue;
		} else {
			return false;
		}
	}
}