package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.pages.CustomerSubscribePage;
import internship.framework.pages.TermsAndConditionsPage;
import org.testng.annotations.Test;

public class TermsAndConditionsTest extends TestBase {

    @Test(testName = "Terms and Conditions Test",
    description = "Testing Terms and Conditions")
    public void checkTermsAndConditions() {
        CustomerSubscribePage customerSubscribePage = new CustomerSubscribePage().openPage();
        customerSubscribePage.clickTermsAndConditionsButton();
        TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage();
        softAssert.get().assertEquals(termsAndConditionsPage.getTermsAndConditionsTitleText(),"Terms and Conditions",
                "Terms and Conditions element is not displayed.");
        softAssert.get().assertEquals(termsAndConditionsPage.getPoliciesAndProcessesChapterText(), "Policies and Processes",
                "Policies and Processes element is not displayed");
        softAssert.get().assertAll();
    }
}
