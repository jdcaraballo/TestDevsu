package com.pichincha.automationtest.util.constants;

import com.pichincha.automationtest.util.EnvironmentConfig;

import java.io.File;

public class Paths {
    private Paths() {
    }

    private static final EnvironmentConfig enviromentConfig = new EnvironmentConfig();
    private static final String USER_HOME_PATH = System.getProperty(Constants.USER_HOME);
    private static final String USER_DIR_PATH = System.getProperty(Constants.USER_DIR);

    private static final String RESOURCES_PATH = USER_DIR_PATH + File.separator + Constants.SRC + File.separator + Constants.TEST + File.separator + Constants.RESOURCES + File.separator;
    private static final String FEATURE_PATH = RESOURCES_PATH + Constants.FEATURES + File.separator;
    private static final String DATA_PATH = RESOURCES_PATH + Constants.DATA + File.separator;
    private static final String PROPERTIES_PATH = RESOURCES_PATH + Constants.PROPERTIES + File.separator;

    public static String userHomePath() {
        return USER_HOME_PATH;
    }

    public static String userDirPath() {
        return USER_DIR_PATH;
    }

    public static String resourcesPath() {
        if (!enviromentConfig.getVariable(Constants.ATTRIB_RESOURCES_PATH).isEmpty())
            return enviromentConfig.getVariable(Constants.ATTRIB_RESOURCES_PATH);
        return RESOURCES_PATH;
    }

    public static String featuresPath() {
        if (!enviromentConfig.getVariable(Constants.ATTRIB_FEATURES_PATH).isEmpty())
            return enviromentConfig.getVariable(Constants.ATTRIB_FEATURES_PATH);
        return FEATURE_PATH;
    }

    public static String dataPath() {
        if (!enviromentConfig.getVariable(Constants.ATTRIB_DATA_PATH).isEmpty())
            return enviromentConfig.getVariable(Constants.ATTRIB_DATA_PATH);
        return DATA_PATH;
    }

    public static String propertiesPath() {
        if (!enviromentConfig.getVariable(Constants.ATTRIB_PROPERTIES_PATH).isEmpty())
            return enviromentConfig.getVariable(Constants.ATTRIB_PROPERTIES_PATH);
        return PROPERTIES_PATH;
    }

    public static String validatePath(String path) {
        String[] separators = {"/", "\\", "-"};
        for (String separator : separators) {
            if (path.contains(separator)) {
                path = path.replace(separator, File.separator);
                break;
            }
        }
        return path;
    }
}