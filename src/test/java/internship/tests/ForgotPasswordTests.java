package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.pages.LoginPage;
import internship.framework.pages.ResetPasswordPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ForgotPasswordTests extends TestBase {

    @Test(testName = "Forgot Password Valid Email Test",
            description = "Testing Forgot Password on Login Page using Valid Email")
    public void testingForgotPasswordValidEmail() {
        checkForgotPasswordTests(true);
    }

    @Test(testName = "Forgot Password Invalid Email",
            description = "Testing Forgot Password Invalid Email")
    public void testingForgotPasswordInvalidEmail() {
        checkForgotPasswordTests(false);
    }

    private void checkForgotPasswordTests(boolean validPassword) {
        softAssert.set(new SoftAssert());
        LoginPage loginPage = new LoginPage().openPage();
        ResetPasswordPage resetPasswordPage = loginPage.clickLogInButtonHome()
                .clickForgotPassword();
        softAssert.get().assertTrue(resetPasswordPage.isResetPasswordTextDisplayed(), "Failed to display forgot password page.");
        if (validPassword) {
            resetPasswordPage.enterValidPassword().clickResetPasswordButton();
            softAssert.get().assertTrue(resetPasswordPage.isResetConfirmationDisplayed(), "Failed to display reset confirmation page.");
        } else {
            resetPasswordPage.enterInvalidPassword().clickResetPasswordButton();
            softAssert.get().assertTrue(resetPasswordPage.isIncorrectEmailFormatDisplayed(), "Failed to display reset confirmation page.");
        }
        softAssert.get().assertAll();
    }
}
