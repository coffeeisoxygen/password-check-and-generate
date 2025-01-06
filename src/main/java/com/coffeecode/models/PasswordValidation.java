package com.coffeecode.models;

import com.coffeecode.models.ValidationResult.ValidationLevel;

public interface PasswordValidation {

    ValidationResult validate(String password);

    String getValidatorName();

    ValidationLevel getValidationLevel();  // New method
}
