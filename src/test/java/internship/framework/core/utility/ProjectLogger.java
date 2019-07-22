package internship.framework.core.utility;

import com.relevantcodes.extentreports.LogStatus;
import internship.framework.core.runner.ExtentTestManager;
import org.apache.log4j.Logger;

import java.lang.reflect.Method;

public class ProjectLogger {
    private static ThreadLocal<ProjectLogger> logger = ThreadLocal.withInitial(ProjectLogger::new);

    private Logger log;

    private ProjectLogger() {
    }

    public static String getName(){
        return (logger.get()).log.getName();
    }

    public static void info(String message) {
        (logger.get()).log.info(message);
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().log(LogStatus.INFO, message);
        }
    }

    public static void set(Method method) {
        ProjectLogger.logger.get().log = Logger.getLogger(method.getName());
    }

    public static void remove() {
        logger.remove();
    }
}
