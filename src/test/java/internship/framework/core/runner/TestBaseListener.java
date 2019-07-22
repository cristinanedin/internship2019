package internship.framework.core.runner;

import com.relevantcodes.extentreports.LogStatus;
import internship.framework.core.utility.Driver;
import internship.framework.core.utility.ProjectLogger;
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import static internship.framework.core.utility.PropertiesReader.getInputStream;
import static org.testng.xml.XmlSuite.ParallelMode.METHODS;

public class TestBaseListener implements ITestListener {
    private static final Logger Log = Logger.getLogger(TestBaseListener.class);

    @Override
    public void onStart(ITestContext result) {
        getInputStream("log4j.properties");
        Log.info("Start Test Suite: " + result.getCurrentXmlTest().getSuite().getName());
        Log.info("\n----------------------------------------------------------------"
            + "\n\nWatch your tests live: http://tim-vm-036.3pillar.corp:4444/grid/admin/live\n\n"
            + "\n-----------------------------------------------------------------");

        result.getCurrentXmlTest().setParallel(METHODS);
        result.getCurrentXmlTest().setThreadCount(Integer.valueOf(GlobalProperties.PARALLEL_THREADS));
        result.getCurrentXmlTest().setVerbose(result.getCurrentXmlTest().getVerbose());
        ExtentManager.getReporter();
    }

    @Override
    public void onFinish(ITestContext result) {
        if (GlobalProperties.VIDEO_RECORDING.equals("true")) {
            Log.info("\n----------------------------------------------------------------------------"
                + "\n\nYour recording are available at: http://tim-vm-036.3pillar.corp:4444/dashboard/#\n\n"
                + "\n----------------------------------------------------------------------------");
        }
        ExtentManager.getReporter().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        setZaleniumCookie("zaleniumTestPassed", "true");
        ExtentTestManager.getTest().log(LogStatus.PASS, "TEST PASS!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTestManager.getTest().log(LogStatus.FAIL, "TEST FAILED!");
        ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Case Failed is '" + result.getName() + "'");
        ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
        ExtentTestManager.getTest().log(LogStatus.FAIL, "<a href=" + getScreenShot() + ">Click for screenshot</a>");
        setZaleniumCookie("zaleniumTestPassed", "false");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Reporter.log("Test Failed in setup");
        setZaleniumCookie("zaleniumMessage", "Test Failed in Set-Up");
        ExtentTestManager.getTest().log(LogStatus.SKIP, "TEST SKIPPED!");
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Case Skipped is '" + result.getName() + "'");
        ExtentTestManager.getTest().log(LogStatus.SKIP, result.getThrowable());
        ExtentTestManager.getTest().log(LogStatus.SKIP, "<a href=" + getScreenShot() + ">Click for screenshot</a>");
    }

    private void setZaleniumCookie(String zaleniumMessage, String s) {
        Cookie cookie = new Cookie(zaleniumMessage, s);
        Driver.get().get(GlobalProperties.BASE_URL);
        Driver.get().manage().addCookie(cookie);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    private static String getScreenShot() {
        String base64Screenshot = null;
        try {
            base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) Driver.get()).
                getScreenshotAs(OutputType.BASE64);
        } catch (WebDriverException e) {
            ProjectLogger.info(e.getMessage());
        }
        return base64Screenshot;
    }
}