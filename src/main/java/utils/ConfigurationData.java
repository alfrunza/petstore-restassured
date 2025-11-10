package utils;

import java.util.Properties;

/**
 * Utility class to fetch configuration data from a properties file.
 */
public class ConfigurationData {

    /**
     * Retrieves the value associated with the given key from the config.properties file.
     *
     * @param value The key whose value needs to be fetched.
     * @return The value associated with the key, or null if an error occurs.
     */
    private static String getValueFromConfigFile(String value) {
        Properties properties = new Properties();
        String propertiesFileName = "config.properties";
        try {
            properties.load(ConfigurationData.class.getClassLoader().getResourceAsStream(propertiesFileName));
            return properties.getProperty(value);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Retrieves the base URL from the configuration file.
     *
     * @return The base URL as a String.
     */
    public static String getBaseUrl() {
        return getValueFromConfigFile("baseUrl");
    }

    /**
     * Retrieves the API key from the configuration file.
     *
     * @return The API key as a String.
     */
    public static String getApiKey() {
        return getValueFromConfigFile("apiKey");
    }
}
