package org.omm.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.omm.validation.validator.CategoryValidator;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CategoryValidator.class)
public @interface Category {

    String message() default "{org.omm.model.Product.category}";


    Class<?>[] groups() default {};
    public abstract Class<? extends Payload>[] payload()
            default {};
}
