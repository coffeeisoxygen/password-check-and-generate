package com.coffeecode.models;

import java.util.List;

import com.coffeecode.models.ValidationResult.ValidationLevel;

public class LengthValidator implements PasswordValidation {

    private static final String VALIDATOR_NAME = "Length Validator";
    private final int minLength;

    public LengthValidator(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public ValidationResult validate(String password) {
        if (password == null) {
            return createValidationResult(false,
                    "Password cannot be null",
                    List.of("Password must not be null"),
                    ValidationLevel.ERROR);
        }

        boolean valid = password.length() >= minLength;
        return createValidationResult(
                valid,
                valid ? "Length check passed" : "Password too short",
                List.of(String.format("Minimum length required: %d, actual: %d",
                        minLength, password.length())),
                valid ? ValidationLevel.PASS : ValidationLevel.ERROR
        );
    }

    @Override
    public String getValidatorName() {
        return VALIDATOR_NAME;
    }

    @Override
    public ValidationLevel getValidationLevel() {
        return ValidationLevel.ERROR;
    }

    private ValidationResult createValidationResult(
            boolean isValid,
            String message,
            List<String> details,
            ValidationLevel severity) {
        return new ValidationResult(isValid, message, details, severity);
    }
}
