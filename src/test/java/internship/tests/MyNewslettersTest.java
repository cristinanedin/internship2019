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

    @Test(testName = "My Newsletters Test",
            description = "Testing My Newsletters functionality")
    public void TestingMyNewslettersFunctionality() {
        softAssert.set(new SoftAssert());
        LoginPage loginPage=new LoginPage().openPage();
        loginPage.clickLogInButtonHome();
        loginPage.enterEmail(GlobalProperties.USERNAME_VALUE)
                 .enterPassword(GlobalProperties.PASSWORD_VALUE)
                 .clickLogInButton()
                 .clickMyAccountButton();
        MynewslettersPage mynewslettersPage = new MyAccountPage().clickMyNewslettersButton()
                                                                 .addNewsletters();
        softAssert.get().assertTrue(mynewslettersPage.checkSubscribeNewsletters(),
                "My newsletters element is not displayed.");
        mynewslettersPage.unsubscribeNewsletters()
                         .clickRightTopArrow();
        softAssert.get().assertAll();
    }

    @Override
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        softAssert.remove();
        super.tearDown();
    }
}
