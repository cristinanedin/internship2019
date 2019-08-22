package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.core.runner.GlobalProperties;
import internship.framework.pages.LoginPage;
import internship.framework.pages.MyAccountPage;
import internship.framework.pages.MynewslettersPage;
import org.testng.annotations.Test;

public class MyNewslettersTest extends TestBase {
    private final String ADD_NEWSLETTER_VALID_TEXT = "We've added";

    @Test(testName = "My Newsletters Test",
            description = "Testing My Newsletters functionality",
            priority = 1)
    public void TestingMyNewslettersFunctionality() {
        login();
        new MyAccountPage().clickMyNewslettersButton();
        MynewslettersPage mynewslettersPage = new MynewslettersPage().addNewsletters();
        softAssert.get().assertTrue(mynewslettersPage.checkSubscribeNewsletters(),
                "My newsletters element is not displayed.");
        mynewslettersPage.clickRightTopArrow();
        softAssert.get().assertAll();
    }

    @Test(dependsOnMethods = {"TestingMyNewslettersFunctionality"}, testName = "My Account Test",
            description = "Testing My Account functionality",
            priority = 1)
    public void TestingMyAccountFunctionality() {
        login();
        MyAccountPage myAccountPage = new MyAccountPage().clickMyNewslettersButton()
                .navigateMyAccount()
                .addNewsletter();
        softAssert.get().assertTrue(myAccountPage.isValidateNewsletterDisplayed(),
                "Validate newsletter element is not displayed.");
        softAssert.get().assertTrue(myAccountPage.getValidateNewsletterText().contains(ADD_NEWSLETTER_VALID_TEXT),
                "Validating text from adding newsletter has failed.");
        softAssert.get().assertAll();
    }

    private void login() {
        LoginPage loginPage = new LoginPage().openPage();
        loginPage.clickLogInButtonHome();
        loginPage.enterEmail(GlobalProperties.USERNAME_VALUE)
                .enterPassword(GlobalProperties.PASSWORD_VALUE)
                .clickLogInButton()
                .clickMyAccountButton();
    }
}
