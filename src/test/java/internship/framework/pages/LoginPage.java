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

    public void clickLogInButton() {
        ProjectLogger.info("Login site");
        ElementUtils.clickOn(loginButton);

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

    public boolean isMyAccountDisplayed() {
        return doesAppear(myAccountLabel);
    }

}