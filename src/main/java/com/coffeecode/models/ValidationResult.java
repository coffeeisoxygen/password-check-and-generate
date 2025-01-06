package com.coffeecode.models;

import java.util.List;

public record ValidationResult(
        boolean isValid,
        String message,
        List<String> details,
        ValidationLevel severity) {

    public enum ValidationLevel {
        PASS("Valid"),
        WARNING("Warning"),
        ERROR("Error");

        private final String description;

        ValidationLevel(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
}
