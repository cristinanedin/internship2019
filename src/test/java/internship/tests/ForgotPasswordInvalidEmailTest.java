package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.pages.LoginPage;
import internship.framework.pages.ResetPasswordPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ForgotPasswordInvalidEmailTest extends TestBase {

    @Test(testName = "Forgot Password Invalid Email", description = "Testing Forgot Password Invalid Email")
    public void TestingForgotPasswordInvalidEmail()
    {
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage().openPage();
        ResetPasswordPage resetPasswordPage = new LoginPage().clickLogInButtonHome()
                                                             .clickForgotPassword();
        softAssert.assertTrue(resetPasswordPage.isResetPasswordTextDisplayed(), "Failed to display forgot password page.");
        resetPasswordPage.enterInvalidPassword()
                         .clickResetPasswordButton();
        softAssert.assertTrue(resetPasswordPage.isIncorrectEmailFormatDisplayed(), "Failed to display reset confirmation page.");
        softAssert.assertAll();
    }
}
