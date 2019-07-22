package internship.framework.core.runner;

import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;

class ExtentManager {

    private static ExtentReports extent;
    private final static String fileName = "Extent.html";

    synchronized static ExtentReports getReporter() {
        if (extent == null) {
            String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/target/";
            extent = new ExtentReports(reportDirectory + fileName, true);
            extent.loadConfig(new File("src/test/resources/extent-config.xml"));
        }
        return extent;
    }
}