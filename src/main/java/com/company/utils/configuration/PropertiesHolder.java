package com.company.utils.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesHolder {
    private static Logger log = LogManager.getLogger(PropertiesHolder.class);

    private static final String CONFIGURATION_PROPERTIES_PATH = "configuration.properties";
    public static Properties configurationProperties;

    private static final String ENVIRONMENT_PROPERTIES_PATH = "environment.properties";
    public static Properties environmentProperties;

    public static void populateConfigurationProperties() throws IOException {
        configurationProperties = populateProperties(CONFIGURATION_PROPERTIES_PATH);
    }

    public static void populateEnvironmentProperties() throws IOException {
        environmentProperties = populateProperties(ENVIRONMENT_PROPERTIES_PATH);

        String environment = PropertiesHolder.environmentProperties.getProperty("environment");
        if(environment==null)
            throw new RuntimeException("NO ENVIRONMENT SPECIFIED IN ENVIRONMENT.PROPERTIES");
        environmentProperties.putAll(populateProperties(environment + "_" + ENVIRONMENT_PROPERTIES_PATH));

    }

    public static Properties populateProperties(String path) throws IOException {
        Properties properties = new Properties();
        try( InputStream is = PropertiesHolder.class.getClassLoader().getResourceAsStream(path);) {
            properties.load(is);
            return properties;
        } catch (Exception e) {
            log.error("Error loading properties " +TestConfiguration.USER_DIR + "\\" + path, e);
            throw e;
        }


    }
}
