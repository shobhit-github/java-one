package com.learning.springboot.utilities.validators;

import com.learning.springboot.dao.TempleRepository;
import com.learning.springboot.dao.UnionRepository;
import com.learning.springboot.dao.UserRepository;
import com.learning.springboot.utilities.annotations.UniqueEmail;
import com.learning.springboot.utilities.enums.UserType;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailConstraintValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UnionRepository unionRepository;

    @Autowired
    private TempleRepository templeRepository;



    @Override
    public boolean isValid(String target, ConstraintValidatorContext constraintValidatorContext) {

        boolean isExist = false;
        UserType checkFor = (UserType) ((ConstraintValidatorContextImpl) constraintValidatorContext).getConstraintDescriptor().getAttributes().get("checkFor");

        try {
            switch (checkFor) {
                case TEMPLE_MANAGEMENT -> isExist = templeRepository.existsByEmail(target);
                case UNION -> isExist = unionRepository.existsByEmail(target);
                default -> isExist = userRepository.existsByEmail(target);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return !isExist;
    }


}
