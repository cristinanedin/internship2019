package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.pages.InternationalSubscribePage;
import org.testng.annotations.Test;

public class InternationalSubscribeTest extends TestBase {

    @Test(testName = "International subscribe test",
            description = "Testing International Subscribe page offers.",
            priority = 1)
    public void checkPriceOffersDisplayedInDollars() {
        InternationalSubscribePage internationalSubscribePage = new InternationalSubscribePage().open();
        softAssert.get().assertTrue(internationalSubscribePage.payMonthlyStandardAccessPriceText().contains("$2"),
                "Pay monthly standard access price is not displayed in dollars,");
        softAssert.get().assertTrue(internationalSubscribePage.payMonthlyAllDigitalAccessPriceText().contains("$3"),
                "Pay monthly all digital access price is not displayed in dollars,");
        internationalSubscribePage.clickPayAnnuallyElement();
        softAssert.get().assertTrue(internationalSubscribePage.payAnnuallyStandardAccessPriceText().contains("$75"),
                "Pay annually standard access price is not displayed in dollars.");
        softAssert.get().assertTrue(internationalSubscribePage.payAnnuallyAllDigitalAccessPriceText().contains("$150"),
                "Pay annually all digital access price is not displayed in dollars.");
        softAssert.get().assertTrue(internationalSubscribePage.unlimitedAccess24HoursPriceText().contains("$1"),
                "Unlimited access 24 hours price is not displayed in dollars.");
        softAssert.get().assertAll();
    }
}
