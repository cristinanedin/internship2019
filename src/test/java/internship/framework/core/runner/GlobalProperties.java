package internship.framework.core.runner;

import internship.framework.core.utility.PropertiesReader;

public class GlobalProperties {

    private static PropertiesReader configProperties = new PropertiesReader("config.properties");

    public static final String BROWSER = configProperties.getPropertyValue("browser");

    public static final String SELENIUM_SERVER = configProperties.getPropertyValue("selServer");

    public static final String PARALLEL_THREADS = configProperties.getPropertyValue("parallelThreads");

    public static final String VIDEO_RECORDING = configProperties.getPropertyValue("recordVideo");

    public static final String USERNAME_VALUE = configProperties.getPropertyValue("username");

    public static final String PASSWORD_VALUE = configProperties.getPropertyValue("password");

    public static final String BASE_URL = configProperties.getPropertyValue("base.url");
}
