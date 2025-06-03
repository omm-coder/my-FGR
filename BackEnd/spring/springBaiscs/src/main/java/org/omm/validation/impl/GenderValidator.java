package org.omm.validation.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.omm.validation.GenderCriteria;

public class GenderValidator implements ConstraintValidator<GenderCriteria, String> {
    @Override
    public void initialize(GenderCriteria constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = s == null;
        return result;
    }
}
