package com.example.vehicleinspection.model.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
// Custom constraint annotation for validating date order

@Constraint(validatedBy = EndDateAfterStartDateValidator.class)
@Target({ ElementType.TYPE }) // Applies to class level (like DTOs)
@Retention(RetentionPolicy.RUNTIME)
public @interface EndDateAfterStartDate {
    String message() default "End date must be after start date";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}