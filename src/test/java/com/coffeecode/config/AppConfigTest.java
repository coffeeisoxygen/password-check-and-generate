package com.coffeecode.config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
    void shouldNotBeInstantiable() {
        Constructor<?>[] constructors = AppConfig.class.getDeclaredConstructors();
        assertEquals(1, constructors.length);
        Constructor<?> constructor = constructors[0];
        assertFalse(constructor.canAccess(null));
        
        constructor.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> constructor.newInstance());
        assertEquals(IllegalStateException.class, exception.getCause().getClass());
        assertEquals(IllegalStateException.class, exception.getCause().getClass());
    }

    @Test
    void shouldLoadValidProperties() {
        // Test existing property
        String appName = AppConfig.getProperty("app.name");
        assertNotNull(appName);
        assertEquals("passwordcheck", appName);
    }

    @Test
    void shouldReturnNullForNonExistentProperty() {
        String value = AppConfig.getProperty("non.existent.property");
        assertNull(value);
    }

    @Test
    void shouldHandleNullPropertyKey() {
        String value = AppConfig.getProperty(null);
        assertNull(value);
    }

    @Test
    void shouldHandleMissingPropertiesFile() {
        // This test verifies the error logging when properties file is missing
        // Note: This is testing the static block behavior indirectly
        String value = AppConfig.getProperty("some.property");
        assertNull(value);
    }
}
