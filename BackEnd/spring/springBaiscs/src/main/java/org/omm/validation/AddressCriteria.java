package org.omm.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.omm.validation.impl.AddressValidator;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AddressValidator.class)
public @interface AddressCriteria {

    int lower() default 3;
    int upper() default 6;
    String message() default "Address should be in capital letters " +
            "and should have length of 3-6";


    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};
}
