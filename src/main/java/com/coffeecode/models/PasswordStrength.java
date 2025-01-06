package com.coffeecode.models;

public enum PasswordStrength {
    VERY_WEAK(0, "Very Weak"),
    WEAK(1, "Weak"),
    MEDIUM(2, "Medium"),
    STRONG(3, "Strong"),
    VERY_STRONG(4, "Very Strong");

    private final int score;
    private final String description;

    PasswordStrength(int score, String description) {
        this.score = score;
        this.description = description;
    }
}
