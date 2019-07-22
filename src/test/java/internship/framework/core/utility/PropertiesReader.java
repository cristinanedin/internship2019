package internship.framework.core.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private Properties prop;

    public PropertiesReader(String propertyFileName) {

        prop = new Properties();
        try {
            prop.load(getInputStream(propertyFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static InputStream getInputStream(String propertyFileName) {
        return PropertiesReader.class.getClassLoader().getResourceAsStream(propertyFileName);
    }

    public String getPropertyValue(String property) {
        return prop.getProperty(property);
    }

}