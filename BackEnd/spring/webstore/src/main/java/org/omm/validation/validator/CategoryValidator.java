package org.omm.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.omm.validation.Category;

public class CategoryValidator implements ConstraintValidator<Category,String> {
    String[] allowedCategories = {"laptop","mobile","tablet",
            "charger","earPhone","speaker"};
    @Override
    public boolean isValid(String s,
                           ConstraintValidatorContext constraintValidatorContext) {

        for (String str: allowedCategories){
            System.out.println(str+"equals" + s + " = "+str.equalsIgnoreCase(s));
            if(str.equalsIgnoreCase(s))
                return true;
        }
        return false;
    }
}
