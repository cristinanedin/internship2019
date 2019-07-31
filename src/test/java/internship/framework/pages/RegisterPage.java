package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.utility.NavigationUtils;
import internship.framework.core.utility.ProjectLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static internship.framework.core.utility.ElementUtils.clickOn;
import static internship.framework.core.utility.ElementUtils.fillInWithValue;

public class RegisterPage extends PageBase {
    public RegisterPage() {
        super();
    }

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailRegisterInputField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordRegisterInputField;

    @FindBy(xpath = "//button[@class='button primary']")
    private WebElement accessRegisterButton;

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

    public RegisterCompletePage clickRegisterButtonOnForm() {
        ProjectLogger.info("Click Register button");
        clickOn(accessRegisterButton);
        return new RegisterCompletePage();
    }
}