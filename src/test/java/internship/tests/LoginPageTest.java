package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.pages.Homepage;
import internship.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    private static final String EMAIL_ADDRESS = "nicoricicllaudia@yahoo.ro";
    private static final String PASSWORD_TEXT = "Telegraph1!";

    @Test(testName = "Open Login page",
            description = "Open page and verify login")
    public void checkLoginPage() {

        LoginPage loginPage = new Homepage().clickLoginButton();

        loginPage.enterEmail(EMAIL_ADDRESS)
                .enterPassword(PASSWORD_TEXT)
                .clickLogInButton();
        Assert.assertTrue(loginPage.isUserLoggedIn(), "User is not logged in");

    }
}