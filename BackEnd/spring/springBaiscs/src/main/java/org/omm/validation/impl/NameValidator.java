package org.omm.validation.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.omm.validation.NameCriteria;

public class NameValidator implements ConstraintValidator<NameCriteria,String> {

    int lower;
    int upper;

    @Override
    public void initialize(NameCriteria name) {
      this.lower = name.lower();
      this.upper = name.upper();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        return !s.isEmpty() || (s.length() >= lower && s.length() <= upper);
    }
}
