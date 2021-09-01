package com.akhilesh.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CustomerIdConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomerId {
    public String value() default "CUSTID";

    public String message() default "Must start with CUSTID";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
