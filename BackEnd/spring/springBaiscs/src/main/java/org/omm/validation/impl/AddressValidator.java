package org.omm.validation.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.omm.validation.AddressCriteria;

import java.util.regex.Pattern;

public class AddressValidator implements ConstraintValidator<AddressCriteria, String> {

    int lower, upper;
    @Override
    public void initialize(AddressCriteria address) {
        this.lower = address.lower();
        this.upper = address.upper();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isTrue = false;
        if (s.length() >= lower && s.length() <= upper)
            isTrue = Pattern.matches("([A-Z])*", s);
        return isTrue;
    }
}
