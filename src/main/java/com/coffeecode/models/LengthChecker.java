package com.coffeecode.models;

public class LengthChecker implements PasswordChecker {

    private static final int MIN_LENGTH = 8;
    private static final int STRONG_LENGTH = 12;

    @Override
    public CheckResult check(String password) {
        int length = password.length();
        if (length < MIN_LENGTH) {
            return new CheckResult(false, "Password is too short", 0);
        } else if (length >= STRONG_LENGTH) {
            return new CheckResult(true, "Good length", 2);
        }
        return new CheckResult(true, "Acceptable length", 1);
    }
}
