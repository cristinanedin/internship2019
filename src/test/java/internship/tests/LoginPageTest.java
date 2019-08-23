package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.core.runner.GlobalProperties;
import internship.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    @Test(testName = "Open Login page",
            description = "Open page and verify login")
    public void checkLoginPage() {
        LoginPage loginPage = new LoginPage().openPage();
        loginPage.clickLogInButtonHome();
        loginPage.enterEmail(GlobalProperties.USERNAME_VALUE)
                .enterPassword(GlobalProperties.PASSWORD_VALUE)
                .clickLogInButton();
        Assert.assertTrue(loginPage.isMyAccountDisplayed(), "User is not logged in");
    }
}