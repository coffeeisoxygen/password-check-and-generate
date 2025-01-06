package com.coffeecode.models;

public class CheckResult {

    private final boolean passed;
    private final String message;
    private final int score;

    // constructor
    public CheckResult(boolean passed, String message, int score) {
        this.passed = passed;
        this.message = message;
        this.score = score;
    }

    public boolean isPassed() {
        return passed;
    }

    public String getMessage() {
        return message;
    }

    public int getScore() {
        return score;
    }
}
