package com.learning.springboot.utilities.annotations;


import com.learning.springboot.utilities.validators.UniqueDomainConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueDomainConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface UniqueDomain {

    public String message() default "There is already a domain name with this particular website!";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default{};
}

