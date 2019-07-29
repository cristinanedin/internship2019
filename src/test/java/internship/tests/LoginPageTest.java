package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.core.runner.GlobalProperties;
import internship.framework.pages.Homepage;
import internship.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    @Test(testName = "Open Login page",
            description = "Open page and verify login")
    public void checkLoginPage() {

        LoginPage loginPage = new Homepage().clickLoginButton();

        loginPage.enterEmail(GlobalProperties.USERNAME_VALUE)
                .enterPassword(GlobalProperties.PASSWORD_VALUE)
                .clickLogInButton();
        Assert.assertTrue(loginPage.isUserLoggedIn(), "User is not logged in");

    }
}