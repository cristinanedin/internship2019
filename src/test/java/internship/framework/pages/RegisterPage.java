package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.utility.ProjectLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static internship.framework.core.utility.ElementUtils.*;

public class RegisterPage extends PageBase {

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailRegisterInputField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordRegisterInputField;

    @FindBy(xpath = "//button[@class='button primary']")
    private WebElement accessRegisterButton;

    @FindBy(xpath = "//h1[@class='form-container-box-header-right-text']")
    private WebElement confirmRegisterText;

    @FindBy(xpath = "//p[contains(text(),'A Telegraph account associated with this email add')]")
    private WebElement failRegisterText;

    @FindBy(xpath = "//button[@class='evidon-banner-acceptbutton']")
    private WebElement acceptCookiesElement;

    public RegisterPage() {
        super();
    }

    public RegisterPage enterEmailRegister(String emailValue) {
        ProjectLogger.info("Enter email for register");
        fillInWithValue(emailRegisterInputField, emailValue);
        return this;
    }

    public RegisterPage enterPasswordRegister(String passwordValue) {
        ProjectLogger.info("Enter password for register");
        fillInWithValue(passwordRegisterInputField, passwordValue);
        return this;
    }

    public void clickRegisterButtonOnForm() {
        ProjectLogger.info("Click Register button");
        clickOn(accessRegisterButton);
    }

    public String isConfirmRegisterTextDisplayed() {
        ProjectLogger.info("Confirm register text is displayed.");
        return getElementText(confirmRegisterText);
    }

    public String isFailRegisterTextDisplayed() {
        ProjectLogger.info("Fail register text is displayed.");
        return getElementText(failRegisterText);
    }

    public void clickAcceptCookies() {
        ProjectLogger.info("Click Accept cookies button.");
        clickOn(acceptCookiesElement);
    }
}