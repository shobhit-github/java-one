package com.learning.springboot.utilities.annotations;


import com.learning.springboot.utilities.enums.UserType;
import com.learning.springboot.utilities.validators.UniqueEmailConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueEmailConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface UniqueEmail {

    public String message() default "There is already user with this email!";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default{};

    public UserType checkFor() default UserType.DEVOTEE;
}

