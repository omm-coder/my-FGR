package org.omm.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.omm.exception.ProductNotFoundException;
import org.omm.model.Product;
import org.omm.service.impl.ProductServiceIMPL;
import org.omm.validation.ProductId;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductIdValidator implements ConstraintValidator<ProductId,String> {

    @Autowired
    private ProductServiceIMPL serviceIMPL;
    Product product;
    @Override
    public boolean isValid(String s, ConstraintValidatorContext
            constraintValidatorContext) {
        try {
             product = serviceIMPL.getProductById(s);
        }catch (ProductNotFoundException e) {
            return true;
        }
        return product == null;
    }
}
