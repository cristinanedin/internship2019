package internship.framework.core;

import internship.framework.core.runner.ExtentTestManager;
import internship.framework.core.runner.GlobalProperties;
import internship.framework.core.runner.TestBaseListener;
import internship.framework.core.utility.Driver;
import internship.framework.core.utility.ProjectLogger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;

import static internship.framework.core.CommonSteps.openPage;
import static internship.framework.core.utility.Constants.CHROME;
import static internship.framework.core.utility.NavigationUtils.setWindowSize;

@Listeners ({TestBaseListener.class})
public class TestBase {

    @BeforeMethod (alwaysRun = true)
    public void setUp(Method method) {
        ProjectLogger.set(method);
        initializeExtentTest(method);
        rootInit(method);
        openPage();
    }

    private void initializeExtentTest(Method method) {
        String testName = method.getAnnotation(Test.class).testName();
        String testDescription = method.getAnnotation(Test.class).description();
        if (testName.isEmpty()) {
            ExtentTestManager.startTest(method.getName());
        } else {
            ExtentTestManager.startTest(testName, testDescription);
        }
    }

    private void rootInit(Method method) {
        ProjectLogger.info("Setup driver start...");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (GlobalProperties.BROWSER.equals(CHROME)) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            options.addArguments("--no-sandbox");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        } else {
            capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, new FirefoxOptions());
            capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
        }
        capabilities.setCapability("name", method.getName());
        capabilities.setCapability("idleTimeout", 150);
        capabilities.setCapability("screenResolution", "1440x800");
        capabilities.setCapability("recordVideo", GlobalProperties.VIDEO_RECORDING);
        try {
            Driver.set(new RemoteWebDriver(
                URI.create(GlobalProperties.SELENIUM_SERVER).toURL(),
                capabilities));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        setWindowSize(1440, 800);
        ProjectLogger.info("Setup driver finished...");
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown() {
        ExtentTestManager.endTest();
        Driver.remove();
    }
}