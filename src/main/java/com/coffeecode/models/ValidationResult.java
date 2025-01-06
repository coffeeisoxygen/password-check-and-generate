package com.coffeecode.models;

import java.util.List;

public record ValidationResult(
        boolean isValid,
        String message,
        List<String> details,
        ValidationLevel severity) {

    public enum ValidationLevel {
        PASS, WARNING, ERROR
    }
}
