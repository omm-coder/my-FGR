package org.omm.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.omm.validation.impl.GenderValidator;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GenderValidator.class)
public @interface GenderCriteria {

    String message() default "should be select one option";

    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};
}
