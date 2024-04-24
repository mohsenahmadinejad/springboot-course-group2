package com.sadatspringbootcourse.socialmedia.customValidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = BirthDateValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface BirthDateConstraint {
    String message() default "Birth Date Constraint";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}