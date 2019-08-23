package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.pages.Homepage;
import internship.framework.pages.TermsAndConditionsPage;
import org.testng.annotations.Test;

public class TermsAndConditionsTest extends TestBase {
    private final String TERMS_AND_CONDITIONS = "Terms and Conditions";
    private final String POLICIES_AND_PROCESSES = "Policies and Processes";

    @Test(testName = "Terms and Conditions Test",
            description = "Testing Terms and Conditions")
    public void checkTermsAndConditions() {
        Homepage homepage = new Homepage().openPage();
        homepage.clickTermsAndConditions();
        TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage();
        softAssert.get().assertEquals(termsAndConditionsPage.getTermsAndConditionsTitleText(), TERMS_AND_CONDITIONS,
                "Terms and Conditions element is not displayed.");
        softAssert.get().assertEquals(termsAndConditionsPage.getPoliciesAndProcessesChapterText(), POLICIES_AND_PROCESSES,
                "Policies and Processes element is not displayed");
        softAssert.get().assertAll();
    }
}
