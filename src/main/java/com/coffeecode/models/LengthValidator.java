package com.coffeecode.models;

import java.util.List;

import com.coffeecode.models.ValidationResult.ValidationLevel;

public class LengthValidator implements PasswordValidation {

    private final int minLength;

    public LengthValidator(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public ValidationResult validate(String password) {
        boolean valid = password.length() >= minLength;
        return new ValidationResult(
                valid,
                valid ? "Length check passed" : "Password too short",
                List.of("Minimum length required: " + minLength),
                valid ? ValidationLevel.PASS : ValidationLevel.ERROR
        );
    }

    @Override
    public String getValidatorName() {
        return "Length Validator";
    }
}
