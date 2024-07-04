package com.itacademy.selenium.utils;

import com.itacademy.selenium.enums.Capability;
import com.itacademy.selenium.enums.PropertyFile;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static final Logger LOGGER = LogManager.getLogger(PropertyReader.class);

    public static String getProperty(PropertyFile propertyFile, Capability capability) {

        Properties properties = new Properties();
        try {
            FileReader fileReader = new FileReader("src/main/resources/" + propertyFile.getPathToFile());
            properties.load(fileReader);
        } catch (IOException e) {
            LOGGER.info("Properties are not loaded. Use default value");
        }
        for (Object key : properties.keySet()) {
            String systemValue = System.getProperty((String) key);
            if (!StringUtils.isEmpty(systemValue)) {
                properties.put(key, systemValue);
            }
        }
        return properties.getProperty(capability.getKey(), capability.getDefaultValue());
    }
//    public static String getUserProperty(String key) {
//
//        Properties properties = new Properties();
//        try {
//            FileReader fileReader = new FileReader("src/main/resources/" + PropertyFile.USER.getPathToFile());
//            properties.load(fileReader);
//        } catch (IOException e) {
//            LOGGER.info("Properties are not loaded. Use default value");
//        }
//
//        return properties.getProperty(key);
//    }

    public static String getConfigProperty(Capability capability) {
        return getProperty(PropertyFile.CONFIG, capability);
    }
//    public static String getUserProperty(Capability capability) {
//        return getProperty(PropertyFile.USER, capability);
//    }
}
