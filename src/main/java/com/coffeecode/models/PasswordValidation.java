package com.coffeecode.models;

public interface PasswordValidation {

    ValidationResult validate(String password);

    String getValidatorName();
}
