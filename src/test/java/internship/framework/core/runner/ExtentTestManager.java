package internship.framework.core.runner;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import internship.framework.core.utility.Driver;
import internship.framework.core.utility.ProjectLogger;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
    private static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    private static ExtentReports extent = ExtentManager.getReporter();

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized void endTest() {
        if (Driver.get() == null) {
            ProjectLogger.info("Driver closed unexpected");
        } else {
            extent.endTest(extentTestMap.get((int) (long) (Thread.currentThread().getId())));
        }
    }

    public static synchronized ExtentTest startTest(String testName) {
        return startTest(testName, "");
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);

        return test;
    }

}