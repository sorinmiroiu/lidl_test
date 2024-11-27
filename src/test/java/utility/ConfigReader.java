package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.yaml");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getUrl() {
        return (String) properties.get("url");
    }

    public static String getBrowser() {
        return (String) properties.get("browser");
    }

    public static Duration getTimeToWait() {
        String timeStr = properties.getProperty("timeToWait");
        return Duration.ofSeconds(Long.parseLong(timeStr));
    }
}

