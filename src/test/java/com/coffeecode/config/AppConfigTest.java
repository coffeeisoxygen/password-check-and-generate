package com.coffeecode.config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AppConfigTest {

    private static final String TEST_PROPERTIES_PATH = "src/test/resources/config/application.properties";

    @BeforeAll
    static void setUp() throws IOException {
        // Create test resources directory if it doesn't exist
        new File(TEST_PROPERTIES_PATH).getParentFile().mkdirs();

        // Create test properties file
        try (FileWriter writer = new FileWriter(TEST_PROPERTIES_PATH)) {
            writer.write("app.name=passwordcheck\n");
            writer.write("app.version=1.0-COFFEESHOT\n");
            writer.write("app.min.password.length=8\n");
        }
    }

    @Test
    void testGetProperty_ExistingProperty() {
        // Given an existing property
        String propertyKey = "app.name";

        // When getting the property
        String value = AppConfig.getProperty(propertyKey);

        // Then it should return the correct value
        assertEquals("passwordcheck", value);
    }

    @Test
    void testGetProperty_NonExistentProperty() {
        // Given a non-existent property
        String propertyKey = "non.existent.property";

        // When getting the property
        String value = AppConfig.getProperty(propertyKey);

        // Then it should return null
        assertNull(value);
    }

    @Test
    void testGetProperty_NullKey() {
        // When getting a property with null key
        String value = AppConfig.getProperty(null);

        // Then it should return null
        assertNull(value);
    }

    @Test
    void testAllConfigurationProperties() {
        // Test all expected configuration properties
        assertEquals("passwordcheck", AppConfig.getProperty("app.name"));
        assertEquals("1.0-COFFEESHOT", AppConfig.getProperty("app.version"));
        assertEquals("8", AppConfig.getProperty("app.min.password.length"));
    }
}
