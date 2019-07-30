package internship.framework.pages;

import internship.framework.core.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static internship.framework.core.utility.ElementUtils.*;

public class RegisterCompletePage extends PageBase {
    public RegisterCompletePage() {
        super();
        super.open();
    }

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameInputField;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameInputField;

    @FindBy(xpath = "//button[@class='button primary']")
    private WebElement buttonCompleteRegister;

    @FindBy(xpath = "//div[@class='register-complete-content-form-button']")
    private WebElement buttonCompleteRegisterCheck;

    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement myAccountLabel;


    public RegisterCompletePage enterFirstName(String firstName) {
        fillInWithValue(firstNameInputField, firstName);
        return this;
    }

    public RegisterCompletePage enterLastName(String lastName) {
        fillInWithValue(lastNameInputField, lastName);
        return this;
    }

    public RegisterCompletePage clickCompleteRegisterButton() {
        clickOn(buttonCompleteRegister);
        return this;
    }

    public boolean isUserRegister() {
        return doesAppear(buttonCompleteRegisterCheck);
    }

    public boolean isMyAccountDisplayed() {
        return doesAppear(myAccountLabel);
    }
}