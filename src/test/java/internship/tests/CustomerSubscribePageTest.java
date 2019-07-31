package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.core.utility.ProjectLogger;
import internship.framework.pages.CustomerSubscribePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CustomerSubscribePageTest extends TestBase {
    public final static String EXPECTED_PAY_MONTHLY_TEXT = "Pay monthly";
    public final static String EXPECTED_DAY_TRIAL_TEXT = "Free 30 day trial";
    public final static String EXPECTED_STANDARD_ACCESS_TEXT = "Standard Access";
    public final static String EXPECTED_PER_WEEK_TEXT = "£2 per week";
    public final static String EXPECTED_DIGITAL_ACCESS_TEXT = "All Digital Access";
    public final static String EXPECTED_PER_WEEK2_TEXT = "£3 per week";
    public final static String EXPECTED_PER_WEEK3_TEXT = "From £2 per week";
    public final static String EXPECTED_PER_YEAR_TEXT = "£100 per year";
    public final static String EXPECTED_PER_YEAR2_TEXT = "£200 per year";
    public final static String EXPECTED_PER_YEAR3_TEXT = "From £104 per year";

    @Test(testName = "Subscribe test", description = "open subscribe page")
    public void subscribeTest() {
        SoftAssert softAssert = new SoftAssert();
        CustomerSubscribePage customerSubscribePage = new CustomerSubscribePage().openPage();
        softAssert.assertEquals(customerSubscribePage.getDisplayedPayMonthlyText(), EXPECTED_PAY_MONTHLY_TEXT, "Data doesn't match");
        softAssert.assertEquals(customerSubscribePage.getDisplayedTrial(), EXPECTED_DAY_TRIAL_TEXT, "Data doesn't match");
        softAssert.assertEquals(customerSubscribePage.getDisplayedStandardAccess(), EXPECTED_STANDARD_ACCESS_TEXT, "Data doesn't match");
        softAssert.assertEquals(customerSubscribePage.getDisplayedPerWeek(), EXPECTED_PER_WEEK_TEXT, "Data doesn't match");
        softAssert.assertEquals(customerSubscribePage.getDisplayedDigitalAcces(), EXPECTED_DIGITAL_ACCESS_TEXT, "Data doesn't match");
        softAssert.assertEquals(customerSubscribePage.getDisplayedPerWeek2(), EXPECTED_PER_WEEK2_TEXT, "Data doesn't match");
        softAssert.assertEquals(customerSubscribePage.getDisplayedPerWeek3(), EXPECTED_PER_WEEK3_TEXT, "Data doesn't match");
        customerSubscribePage.pushAnuallyButton();
        ProjectLogger.info("check testing part 1");
        softAssert.assertEquals(customerSubscribePage.getDisplayedStandardAccess(), EXPECTED_STANDARD_ACCESS_TEXT, "Data doesn't match");
        softAssert.assertEquals(customerSubscribePage.getDisplayedPerYear(), EXPECTED_PER_YEAR_TEXT, "Data doesn't match");
        softAssert.assertEquals(customerSubscribePage.getDisplayedDigitalAcces(), EXPECTED_DIGITAL_ACCESS_TEXT, "Data doesn't match");
        softAssert.assertEquals(customerSubscribePage.getDisplayedPerYear2(), EXPECTED_PER_YEAR2_TEXT, "Data doesn't match");
        softAssert.assertEquals(customerSubscribePage.getDisplayedPerYear3(), EXPECTED_PER_YEAR3_TEXT, "Data doesn't match");

        ProjectLogger.info("check testing part 2");
        softAssert.assertAll();

    }
}