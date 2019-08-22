package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.core.utility.ProjectLogger;
import internship.framework.pages.SportPage;
import org.testng.annotations.Test;

public class SportPageTest extends TestBase {

    public static final String SPORT_SUBSCRIPTION_TEXT = "Sport Subscription - Half-price sale";
    public static final String SPORT_WEEKLY_PAYMENT = "£1 per week";
    public static final String SPORT_MONTHLY_PAYMENT = "Free for 30 days then billed as £4.33 per month";
    public static final String SPORT_YEARLY_PAYMENT = "£20 per year";
    public static final String SPORT_YEARLY_HALF = "Half-price sale";


    public static final String SUBSCRIPTION_NOT_FOUND = " Sport Subscription not found ";
    public static final String WEEKLY_PAYMENT_NOT_FOUND = " Weekly payment not found ";
    public static final String MONTHLY_PAYMENT_NOT_FOUNB = " Monthly payment not found ";
    public static final String YEARLY_PAYMENT_NOT_FOUND = " Yearly payment not found ";
    public static final String YEARLY_HALF_NOT_FOUND = " Yearly half payment not found ";

    @Test(testName = "Test text on sport page",
            description = "Open sport page and check if the strings are matching",
            priority = 1)
    public void sportsTests() {
        SportPage sport = new SportPage().openPage();
        softAssert.get().assertEquals(sport.getSportSubscription(), SPORT_SUBSCRIPTION_TEXT, SUBSCRIPTION_NOT_FOUND);
        softAssert.get().assertEquals(sport.getWeeklyPayment(), SPORT_WEEKLY_PAYMENT, WEEKLY_PAYMENT_NOT_FOUND);
        softAssert.get().assertEquals(sport.getMonthlyPayment(), SPORT_MONTHLY_PAYMENT, MONTHLY_PAYMENT_NOT_FOUNB);
        softAssert.get().assertEquals(sport.getYearlyPayment(), SPORT_YEARLY_PAYMENT, YEARLY_PAYMENT_NOT_FOUND);
        softAssert.get().assertEquals(sport.getYearlyHalfPayment(), SPORT_YEARLY_HALF, YEARLY_HALF_NOT_FOUND);
        softAssert.get().assertAll();
        ProjectLogger.info("Test Finished");
    }
}