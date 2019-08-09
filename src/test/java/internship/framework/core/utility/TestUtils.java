package internship.framework.core.utility;

import internship.framework.pages.LoginPage;

public class TestUtils {

    private TestUtils() {
    }

    public static void login() {
        LoginPage loginPage = new LoginPage().openPage();
        loginPage.clickLogInButtonHome();
        loginPage.enterEmail("stroeradu03@gmail.com")
                .enterPassword("qwer1234")
                .clickLogInButton()
                .clickMyAccountButton();
    }
}
