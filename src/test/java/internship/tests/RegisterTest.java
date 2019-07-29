package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.pages.Homepage;
import internship.framework.pages.RegisterCompletePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static internship.framework.core.runner.GlobalProperties.*;

public class RegisterTest extends TestBase {

    @Test(testName = "Open RegisterPage page",
            description = "Open page and verify user is registered")

    public void checkRegisterTest() {
        SoftAssert softAssert = new SoftAssert();

        RegisterCompletePage registerCompletePage = new Homepage().clickRegisterButton()
                .enterEmailRegister(USERNAME_REGISTER_VALUE)
                .enterPasswordRegister(PASSWORD_VALUE)
                .clickRegisterButtonOnForm();

        softAssert.assertTrue(registerCompletePage.isUserRegister(), "User is not registered");

        registerCompletePage.enterFirstName(FIRSTNAME__VALUE)
                .enterLastName(LASTNAME_VALUE)
                .clickCompleteRegisterButton();

        softAssert.assertTrue(new Homepage().isMyAccountDisplayed(), "'My account' label is not displayed");

        softAssert.assertAll();
    }
}