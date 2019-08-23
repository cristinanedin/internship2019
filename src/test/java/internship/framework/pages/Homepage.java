package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.utility.ProjectLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static internship.framework.core.utility.ElementUtils.*;

public class Homepage extends PageBase {

    @FindBy(xpath = "//*[@id='site-logo']")
    private WebElement telegraphLink;

    @FindBy(xpath = "//a[@class='e-site-header-button__link e-site-header-button__link--no-border']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(),'Create an account')]")
    private WebElement registerButton;

    @FindBy(xpath = "//a[contains(text(),'Privacy')]")
    private WebElement privacyAndCookiePolicyLink;

    @FindBy(xpath = "//a[contains(text(),'Terms and Conditions')]")
    private WebElement termsAndConditionsLink;

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
        clickOn(loginButton);
        clickOn(registerButton);
        return new RegisterPage();
    }

    public PrivacyAndCookiePolicyPage clickPrivacyAndCookiePolicyPage() {
        ProjectLogger.info("Navigate to Privacy and Cookie Policy Page.");
        clickOnWithJs(privacyAndCookiePolicyLink);
        return new PrivacyAndCookiePolicyPage();
    }

    public void clickTermsAndConditions() {
        ProjectLogger.info("Navigate to Terms and Conditions Page.");
        clickOnWithJs(termsAndConditionsLink);
    }
}