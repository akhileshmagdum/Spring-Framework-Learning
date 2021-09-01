package com.akhilesh.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomerIdConstraintValidator implements ConstraintValidator<CustomerId,String> {

    private String custIdPrefix;
    @Override
    public void initialize(CustomerId constraintAnnotation) {
       custIdPrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String givenCustId, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if(givenCustId!=null){
            result = givenCustId.startsWith(custIdPrefix);
        }
        else{
            result = false;
        }
        return result;
    }
}
