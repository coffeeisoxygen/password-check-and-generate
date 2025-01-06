package com.coffeecode.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LengthValidatorTest {

    private LengthValidator lengthValidator;

    @BeforeEach
    public void setUp() {
        lengthValidator = new LengthValidator(8);
    }

    @Test
    public void testValidate_PasswordTooShort() {
        ValidationResult result = lengthValidator.validate("short");
        assertFalse(result.isValid());
        assertEquals("Password too short", result.message());
        assertEquals(ValidationResult.ValidationLevel.ERROR, result.severity());
    }

    @Test
    public void testValidate_PasswordLongEnough() {
        ValidationResult result = lengthValidator.validate("longenoughpassword");
        assertTrue(result.isValid());
        assertEquals("Length check passed", result.message());
        assertEquals(ValidationResult.ValidationLevel.PASS, result.severity());
    }

    @Test
    public void testGetValidatorName() {
        assertEquals("Length Validator", lengthValidator.getValidatorName());
    }
}
