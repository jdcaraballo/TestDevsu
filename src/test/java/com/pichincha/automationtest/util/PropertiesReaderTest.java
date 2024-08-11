package com.pichincha.automationtest.util;

import com.pichincha.automationtest.util.constants.Constants;
import org.junit.Test;

import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class PropertiesReaderTest {

    PropertiesReader propertiesReader = new PropertiesReader();
    String nameFileProperties = Constants.PROP_MANUALTEST;
    String findPropertie = Constants.ATTRIB_AZURE_LOCAL_EXECUTION;
    String expectedValue = "azure";

    @Test
    public void getPropValues() {
        Optional<Properties> opProperties = propertiesReader.getPropValues(nameFileProperties);
        Properties properties;
        if (opProperties.isPresent()) {
            properties = opProperties.get();
            if (Objects.nonNull(properties.get(findPropertie))) {
                assertEquals(expectedValue, properties.get(findPropertie));
            }
        }
    }

    @Test
    public void getProperty() {
        String property = propertiesReader.getProperty(findPropertie, nameFileProperties);
        assertEquals(expectedValue, property);
    }
}