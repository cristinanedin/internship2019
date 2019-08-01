package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.pages.Homepage;
import internship.framework.pages.LoginPage;
import internship.framework.pages.ResetPasswordPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ForgotPasswordValidEmailTest extends TestBase {

    @Test(testName = "Forgot Password Valid Email Test",
            description ="Testing Forgot Password on Login Page using Valid Email")
    public void TestingForgotPasswordValidEmail()
    {
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage().openPage();
        loginPage.clickLogInButtonHome()
                 .clickForgotPassword();
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
        softAssert.assertTrue(resetPasswordPage.isResetPasswordTextDisplayed(), "Failed to display forgot password page.");
        resetPasswordPage.enterValidPassword()
                         .clickResetPasswordButton();
        softAssert.assertTrue(resetPasswordPage.isResetConfirmationDisplayed(), "Failed to display reset confirmation page.");

        softAssert.assertAll();
    }
}
