package com.coffeecode.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class LengthValidatorTest {

    private final LengthValidator validator = new LengthValidator(8);

    @Test
    void testValidLength() {
        ValidationResult result = validator.validate("password123");
        assertTrue(result.isValid());
        assertEquals(ValidationResult.ValidationLevel.PASS, result.severity());
    }

    @Test
    void testInvalidLength() {
        ValidationResult result = validator.validate("short");
        assertFalse(result.isValid());
        assertEquals(ValidationResult.ValidationLevel.ERROR, result.severity());
    }

    @Test
    void testNullPassword() {
        ValidationResult result = validator.validate(null);
        assertFalse(result.isValid());
        assertEquals(ValidationResult.ValidationLevel.ERROR, result.severity());
    }
}
