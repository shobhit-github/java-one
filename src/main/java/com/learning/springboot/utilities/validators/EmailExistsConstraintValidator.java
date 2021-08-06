package com.learning.springboot.utilities.validators;

import com.learning.springboot.dao.UserRepository;
import com.learning.springboot.utilities.annotations.UniqueEmail;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailExistsConstraintValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String target, ConstraintValidatorContext constraintValidatorContext) {

        boolean isExist = false;

        try {
            isExist = userRepository.existsByEmail(target);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return !isExist;
    }


}
