package com.learning.springboot.utilities.validators;

import com.learning.springboot.dao.UnionRepository;
import com.learning.springboot.utilities.annotations.UniqueDomain;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueDomainConstraintValidator implements ConstraintValidator<UniqueDomain, String> {

    @Autowired
    private UnionRepository unionRepository;

    @Override
    public boolean isValid(String target, ConstraintValidatorContext constraintValidatorContext) {

        boolean isExist = false;

        try {
            isExist = unionRepository.existsByWebsite(target);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return !isExist;
    }


}
