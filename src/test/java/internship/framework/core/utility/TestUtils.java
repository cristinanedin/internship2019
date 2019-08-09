package internship.framework.core.utility;

import internship.framework.pages.LoginPage;

public class TestUtils {

    private TestUtils() {
    }

    public static void login(String username, String password) {
        LoginPage loginPage = new LoginPage().openPage();
        loginPage.clickLogInButtonHome();
        loginPage.enterEmail(username)
                .enterPassword(password)
                .clickLogInButton()
                .clickMyAccountButton();
    }
}
