package com.coffeecode.config;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppConfig {

    private AppConfig() {
        throw new IllegalStateException("configuration class- dont instantiate");
    
    }

    private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);
    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(AppConfig.class.getClassLoader()
                    .getResourceAsStream("application.properties"));
        } catch (IOException e) {
            logger.error("Failed to load application.properties", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
