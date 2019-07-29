package internship.framework.core.utility;

import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver {
    private static ThreadLocal<Driver> driver = ThreadLocal.withInitial(Driver::new);

    private RemoteWebDriver webDriver;

    private Driver() {
        this.webDriver = null;
    }

    public static Driver instance() {
        return driver.get();
    }

    public static RemoteWebDriver get() {
        return (driver.get()).webDriver;
    }

    public static void set(RemoteWebDriver driver) {
        (Driver.driver.get()).webDriver = driver;
    }

    public static void remove() {
        if (driver.get().webDriver != null) {
            driver.get().webDriver.quit();
        }
        driver.remove();
    }
}