package com.sadatspringbootcourse.socialmedia.customValidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class BirthDateValidator implements
        ConstraintValidator<BirthDateConstraint, LocalDate> {


    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        return localDate.isBefore(LocalDate.now().minusYears(18));
    }
}