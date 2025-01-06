package com.coffeecode.models;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class CommonPasswordChecker {

    private Set<String> commonPasswords = new HashSet<>();

    public CommonPasswordChecker() {
        loadCommonPasswords();
    }

    private void loadCommonPasswords() {
        try (InputStream is = getClass().getResourceAsStream("/data/common_passwords.csv"); BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                commonPasswords.add(line.trim().toLowerCase());
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load common passwords", e);
        }
    }

    public boolean isCommonPassword(String password) {
        return commonPasswords.contains(password.toLowerCase());
    }
}
