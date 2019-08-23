package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.pages.Homepage;
import internship.framework.pages.PrivacyAndCookiePolicyPage;
import org.testng.annotations.Test;

public class PrivacyAndCookiePolicyTest extends TestBase {
    private final String PRIVACY_AND_COOKIE_POLICY_TITLE_TEXT = "Privacy and Cookie Policy";
    private final String PRIVACY_AND_COOKIE_POLICY_URL = "https://www.telegraph.co.uk/about-us/privacy-and-cookie-policy/";

    @Test(testName = "Privacy and Cookie Policy Test",
            description = "Testing Privacy and Cookie Policy functionality")
    public void checkPrivacyAndCookiePolicyFunctionality() {
        Homepage homepage = new Homepage().openPage();
        homepage.clickPrivacyAndCookiePolicyPage();
        PrivacyAndCookiePolicyPage privacyAndCookiePolicyPage = new PrivacyAndCookiePolicyPage();
        softAssert.get().assertEquals(privacyAndCookiePolicyPage.getPrivacyAndCookiePolicyTitleText(), PRIVACY_AND_COOKIE_POLICY_TITLE_TEXT,
                "Privacy and Cookie Policy title text is not displayed.");
        softAssert.get().assertEquals(privacyAndCookiePolicyPage.getPrivacyAndCookiePolicyUrl(), PRIVACY_AND_COOKIE_POLICY_URL,
                "Privacy and Cookie Policy Url is not valid.");
        softAssert.get().assertAll();
    }
}
