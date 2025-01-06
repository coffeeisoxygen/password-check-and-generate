package com.coffeecode.models;

public class PatternChecker implements PasswordChecker {

    @Override
    public CheckResult check(String password) {
        // Check for keyboard patterns
        if (hasKeyboardPattern(password)) {
            return new CheckResult(false, "Contains keyboard pattern", -1);
        }

        // Check for repeating patterns
        if (hasRepeatingPattern(password)) {
            return new CheckResult(false, "Contains repeating pattern", -1);
        }

        return new CheckResult(true, "No obvious patterns", 1);
    }

    private boolean hasKeyboardPattern(String password) {
        // Example implementation to detect simple keyboard patterns
        String[] patterns = {"qwerty", "asdfgh", "zxcvbn"};
        for (String pattern : patterns) {
            if (password.toLowerCase().contains(pattern)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasRepeatingPattern(String password) {
        // Example implementation to detect repeating patterns
        int length = password.length();
        for (int i = 1; i <= length / 2; i++) {
            String substring = password.substring(0, i);
            String repeated = substring.repeat(length / i);
            if (password.equals(repeated)) {
                return true;
            }
        }
        return false;
    }
}
