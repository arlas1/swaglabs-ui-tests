package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Config {
    public static final String browser;
    public static final boolean headless;
    public static final int implicitWaitTime;
    public static final int pageLoadTimeout;
    public static final String username;
    public static final String password;
    public static final String baseUrl;
    public static final String baseTestDataPath;
    public static final String baseReportPath;

    static {
        Properties properties = new Properties();
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find config.properties in the classpath");
            }

            properties.load(input);
            browser = properties.getProperty("browser");
            headless = Boolean.parseBoolean(properties.getProperty("headless"));
            implicitWaitTime = Integer.parseInt(properties.getProperty("implicit.wait.time"));
            pageLoadTimeout = Integer.parseInt(properties.getProperty("page.load.timeout"));
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            baseUrl = properties.getProperty("base.url");
            baseTestDataPath = properties.getProperty("base.test.data.path");
            baseReportPath = properties.getProperty("base.report.path");

        } catch (IOException ex) {
            throw new RuntimeException("Error loading config.properties", ex);
        }
    }

    private Config() {}
}
