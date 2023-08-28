package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private static final String CONFIG_FILE_PATH = "config.properties";
    private static final String PRIVATE_CONFIG_FILE_PATH = "config.private.properties";

    public static String getApiKey() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(PRIVATE_CONFIG_FILE_PATH)){
            properties.load(fis);
            return properties.getProperty("REST_API_KEY");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
