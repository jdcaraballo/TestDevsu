package com.pichincha.automationtest.util.apis;

import org.apache.log4j.Logger;
import org.junit.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class SeleniumFunctions {

    /********** Log Attribute **********/
    private static final Logger LOGGER = Logger.getLogger(SeleniumFunctions.class);

    private final Properties prop = new Properties();
    private final Properties env = new Properties();
    private final InputStream in = SeleniumFunctions.class.getResourceAsStream("/test.properties");
    private final InputStream dat = SeleniumFunctions.class.getResourceAsStream("/enviroments.properties");

    private static final Map<String, String> sceneryData = new HashMap<>();

    public String readProperties(String property) throws IOException {
        prop.load(in);
        return prop.getProperty(property);
    }

    public String readPropertiesDB(String property) throws IOException {
        env.load(dat);
        return env.getProperty(property);
    }

    public void retrieveTestData(String parameter) throws IOException {
        String environment = readPropertiesDB("ENVIRONMENT");
        try {
            saveInScenario(parameter, readProperties(parameter + "." + environment));
            LOGGER.info("[ " + parameter + "." + environment + " ] --> " + sceneryData.get(parameter));
        } catch (IOException e) {
            LOGGER.info(e);
        }

    }

    public void saveInScenario(String key, String text) {
        if (!sceneryData.containsKey(key)) {
            sceneryData.put(key, text);
        } else {
            sceneryData.replace(key, text);
        }
    }

    public String getScenarioData(String key) {
        boolean exist = sceneryData.containsKey(key);
        String text = "";
        if (exist) {
            text = sceneryData.get(key);
        } else {
            Assert.assertTrue(String.format("La clave proporcionada %s no existe en el contexto", key), sceneryData.containsKey(key));
        }
        return text;
    }

}