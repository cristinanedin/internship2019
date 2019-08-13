package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.pages.Homepage;
import internship.framework.pages.RegisterCompletePage;
import internship.framework.pages.RegisterPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static internship.framework.core.runner.GlobalProperties.*;

public class RegisterTest extends TestBase {
    private ThreadLocal<SoftAssert> softAssert = super.softAssert;
    private final String DUPLICATE_USERNAME = "stroeradu03@gmail.com";
    private final String DUPLICATE_PASSWORD = "qwer1234";

    @Test(testName = "Verify successful registration",
            description = "Testing successful registration")
    public void checkSuccessfulRegistration() {
        RegisterCompletePage registerCompletePage = new RegisterCompletePage().openPage();
        register(USERNAME_REGISTER_VALUE, PASSWORD_VALUE);
        softAssert.get().assertTrue(registerCompletePage.isUserRegister(), "User is not registered");
        registerCompletePage.enterFirstName(FIRSTNAME__VALUE)
                .enterLastName(LASTNAME_VALUE)
                .clickCompleteRegisterButton();
        softAssert.get().assertTrue(registerCompletePage.isMyAccountDisplayed(), "'My account' label is not displayed");
        softAssert.get().assertAll();
    }

    @Test(testName = "Verify failed registration",
            description = "Testing failed registration",
            dependsOnMethods = "checkSuccessfulRegistration")
    public void checkFailRegistration() {
        RegisterPage registerPage = new RegisterPage().openPage();
        registerPage.clickAcceptCookies();
        register(DUPLICATE_USERNAME, DUPLICATE_PASSWORD);
        softAssert.get().assertTrue(registerPage.isConfirmRegisterTextDisplayed().contains("Register"));
        softAssert.get().assertTrue(registerPage.isFailRegisterTextDisplayed().contains("address already exists"));
        softAssert.get().assertAll();
    }

    private void register(String username, String password) {
        RegisterPage registerPage = new Homepage().clickRegisterButton();
        registerPage.enterEmailRegister(username)
                .enterPasswordRegister(password)
                .clickRegisterButtonOnForm();
    }
}