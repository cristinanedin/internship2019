package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.core.runner.GlobalProperties;
import internship.framework.pages.LoginPage;
import internship.framework.pages.MyAccountPage;
import internship.framework.pages.MynewslettersPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyNewslettersTest extends TestBase {
    private final ThreadLocal<SoftAssert> softAssert = new ThreadLocal<>();

    private void login()
    {
        LoginPage loginPage=new LoginPage().openPage();
        loginPage.clickLogInButtonHome();
        loginPage.enterEmail(GlobalProperties.USERNAME_VALUE)
                .enterPassword(GlobalProperties.PASSWORD_VALUE)
                .clickLogInButton()
                .clickMyAccountButton();
    }

    @Test(testName = "My Newsletters Test",
            description = "Testing My Newsletters functionality")
    public void TestingMyNewslettersFunctionality() {
        softAssert.set(new SoftAssert());
        login();
        new MyAccountPage().clickMyNewslettersButton();
        MynewslettersPage mynewslettersPage = new MynewslettersPage().addNewsletters();
        softAssert.get().assertTrue(mynewslettersPage.checkSubscribeNewsletters(),
                "My newsletters element is not displayed.");
        mynewslettersPage.clickRightTopArrow();
        softAssert.get().assertAll();
    }

    @Test(dependsOnMethods = {"TestingMyNewslettersFunctionality"}, testName = "My Account Test",
            description = "Testing My Account functionality")
    public void TestingMyAccountFunctionality()
    {
        softAssert.set(new SoftAssert());
        login();
        MyAccountPage myAccountPage = new MyAccountPage().clickMyNewslettersButton()
                                                         .navigateMyAccount()
                                                         .addNewsletter();
        softAssert.get().assertTrue(myAccountPage.isValidateNewsletterDisplayed(),
                "Validate newsletter element is not displayed.");
        softAssert.get().assertTrue(myAccountPage.checkValidateNewsletterText().contains("We've added"),
                "Validating text from adding newsletter has failed.");
        softAssert.get().assertAll();
    }

    @Override
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        softAssert.remove();
        super.tearDown();
    }
}
