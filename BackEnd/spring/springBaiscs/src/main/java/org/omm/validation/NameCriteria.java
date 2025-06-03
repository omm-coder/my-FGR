package org.omm.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.omm.validation.impl.NameValidator;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameValidator.class)
public @interface NameCriteria {

    int lower() default 3;

    int upper() default 45;

    String message() default "Name should be character between 3-45";


    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};

}
