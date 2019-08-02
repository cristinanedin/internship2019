package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.core.utility.Driver;
import internship.framework.pages.ResetPasswordPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ForgotPasswordTests extends TestBase {

    private final ThreadLocal<SoftAssert> softAssert = new ThreadLocal<>();

    @Test(testName = "Forgot Password Valid Email Test",
            description = "Testing Forgot Password on Login Page using Valid Email")
    public void TestingForgotPasswordValidEmail() {
        softAssert.set(new SoftAssert());
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage().checkForgotPasswordTests(true);
    }

    @Test(testName = "Forgot Password Invalid Email", description = "Testing Forgot Password Invalid Email")
    public void TestingForgotPasswordInvalidEmail() {
        softAssert.set(new SoftAssert());
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage().checkForgotPasswordTests(false);
    }
    @Override
    @AfterMethod (alwaysRun = true)
    public void tearDown() {
        softAssert.remove();
        super.tearDown();
    }
}
