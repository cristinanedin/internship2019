package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.utility.ElementUtils;
import internship.framework.core.utility.ProjectLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static internship.framework.core.utility.ElementUtils.doesAppear;


public class LoginPage extends PageBase {

    @FindBy(id = "email")
    private WebElement emailInputField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//button[@class='button primary']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement myAccountLabel;

    @FindBy(xpath = "//div[text()='Login']")
    private WebElement loginButton2;

    @FindBy(css = "a.form-container-box-content-info-text")
    private WebElement forgotPassword;

    @FindBy(xpath = "//h1[@class='form-container-box-header-right-text']")
    private WebElement loginTextElement;

    @FindBy(xpath = "//p[contains(text(),\"Sorry, we can't find an account with this email ad\")]")
    private WebElement failedLoginTextElement;

    public LoginPage enterEmail(String email) {
        ProjectLogger.info("Enter email address");
        ElementUtils.fillInWithValue(emailInputField, email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        ProjectLogger.info("Enter password email");
        ElementUtils.fillInWithValue(passwordInputField, password);
        return this;
    }

    public LoginPage clickLogInButton() {
        ProjectLogger.info("Login site");
        ElementUtils.clickOn(loginButton);
        return this;

    }

    public LoginPage clickLogInButtonHome() {
        ProjectLogger.info("Login site");
        ElementUtils.clickOn(loginButton2);
        return this;

    }

    public ResetPasswordPage clickForgotPassword() {
        ProjectLogger.info("Click forgot password button");
        ElementUtils.clickOn(forgotPassword);
        return new ResetPasswordPage();
    }

    public LoginPage clickMyAccountButton()
    {
        ProjectLogger.info("Click My Account button.");
        ElementUtils.clickOn(myAccountLabel);
        return this;
    }

    public boolean isMyAccountDisplayed() {
        ProjectLogger.info("Check if My account is displayed.");
        return doesAppear(myAccountLabel);
    }

    public String isLoginTextDisplayed()
    {
        ProjectLogger.info("Check if login text is displayed.");
        return ElementUtils.getElementText(loginTextElement);
    }

    public String isFailedLoginTextDisplayed()
    {
        ProjectLogger.info("Check if failed login is displayed.");
        return ElementUtils.getElementText(failedLoginTextElement);
    }

}