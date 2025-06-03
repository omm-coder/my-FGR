package org.omm.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.omm.validation.validator.ProductIdValidator;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProductIdValidator.class)
public @interface ProductId {

    String message() default "{org.omm.model.Product.productId}";

    Class<?>[] groups() default {};
    public abstract Class<? extends Payload>[] payload()
            default {};

}
