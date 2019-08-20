package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.utility.ProjectLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static internship.framework.core.utility.ElementUtils.*;

public class Homepage extends PageBase {

    @FindBy(xpath = "//a[@class = 'header-logobar__link']")
    private WebElement telegraphLink;

    @FindBy(xpath = "//div[text()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//ul[contains(@class,'header-nav-global__list header-nav-global__engagement')]//li[3]//a[1]")
    private WebElement registerButton;

    @FindBy(xpath = "//a[contains(text(),'Privacy')]")
    private WebElement privacyAndCookiePolicyLink;

    public boolean isTelegraphLogoDisplayed() {
        return doesAppear(telegraphLink);
    }

    public LoginPage clickLoginButton() {
        ProjectLogger.info("Navigate to Login Page");
        clickOn(loginButton);
        return new LoginPage();
    }

    public RegisterPage clickRegisterButton() {
        ProjectLogger.info("Navigate to Register page");
        clickOn(registerButton);
        return new RegisterPage();
    }

    public PrivacyAndCookiePolicyPage clickPrivacyAndCookiePolicyPage() {
        ProjectLogger.info("Navigate to Privacy and Cookie Policy Page.");
        clickOnWithJs(privacyAndCookiePolicyLink);
        return new PrivacyAndCookiePolicyPage();
    }
}