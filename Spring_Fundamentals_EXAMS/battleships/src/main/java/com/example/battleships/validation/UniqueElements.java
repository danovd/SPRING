package com.example.battleships.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueElementsValidator.class)
public @interface UniqueElements {
    String message() default "Duplicate elements are not allowed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
