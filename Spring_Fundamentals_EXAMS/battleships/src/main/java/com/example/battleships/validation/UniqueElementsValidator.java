package com.example.battleships.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UniqueElementsValidator implements ConstraintValidator<UniqueElements, Collection<?>> {
    @Override
    public void initialize(UniqueElements constraintAnnotation) {
    }

    @Override
    public boolean isValid(Collection<?> collection, ConstraintValidatorContext context) {
        if (collection == null) {
            return true;
        }

        Set<Object> uniqueElements = new HashSet<>();
        for (Object element : collection) {
            if (!uniqueElements.add(element)) {
                return false; // Duplicates found
            }
        }

        return true; // No duplicates found
    }
}
