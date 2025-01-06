package com.coffeecode.models;

public class CharacterCombinationChecker implements PasswordChecker {

    @Override
    public CheckResult check(String password) {
        int score = 0;
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                hasSpecial = true;
            }
        }

        score += (hasLower ? 1 : 0);
        score += (hasUpper ? 1 : 0);
        score += (hasDigit ? 1 : 0);
        score += (hasSpecial ? 1 : 0);

        return new CheckResult(score > 2,
                String.format("Uses %d different character types", score), score);
    }
}
