package internship.framework.core;

import internship.framework.pages.Homepage;

import static internship.framework.core.utility.ProjectLogger.info;

public class CommonSteps {

    private CommonSteps() {
    }

    public static void openPage() {
        Homepage homepage = new Homepage();
        info("Test start");
        homepage.open();
        info("Test finish");
    }
}