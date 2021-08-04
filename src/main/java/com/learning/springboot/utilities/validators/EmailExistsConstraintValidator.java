package com.learning.springboot.utilities.validators;

import com.learning.springboot.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class EmailExistsConstraintValidator implements ConstraintValidator {


    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(Annotation constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object target, ConstraintValidatorContext constraintValidatorContext) {

        boolean isExist = false;

        try {
            isExist = userRepository.existsByEmail((String) target);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isExist;
    }
}
