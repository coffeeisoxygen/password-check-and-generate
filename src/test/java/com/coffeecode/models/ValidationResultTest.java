package com.coffeecode.models;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ValidationResultTest {

    @Test
    void testValidationResult() {
        ValidationResult result = new ValidationResult(true, "Test message", List.of(), ValidationResult.ValidationLevel.PASS);
        assertTrue(result.isValid());
        assertEquals("Test message", result.message());
        assertEquals(ValidationResult.ValidationLevel.PASS, result.severity());
    }

    @Test
    void testValidationLevel() {
        assertEquals(3, ValidationResult.ValidationLevel.values().length);
        assertNotNull(ValidationResult.ValidationLevel.valueOf("PASS"));
        assertNotNull(ValidationResult.ValidationLevel.valueOf("WARNING"));
        assertNotNull(ValidationResult.ValidationLevel.valueOf("ERROR"));
    }
}
