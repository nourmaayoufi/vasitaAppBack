package com.example.vehicleinspection.model.validators;

import com.example.vehicleinspection.dto.request.UserRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
// Implements the custom validator for checking if endDate > startDate

public class EndDateAfterStartDateValidator implements ConstraintValidator<EndDateAfterStartDate, UserRequest> {
    // The validation logic

    @Override
    public boolean isValid(UserRequest request, ConstraintValidatorContext constraintValidatorContext) {
        if (request.getStartDate() == null || request.getEndDate() == null) {
            return true;
        }
        // Return true if end date is after start date

        return request.getEndDate().isAfter(request.getStartDate());
    }
}
