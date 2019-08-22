package internship.framework.pages;

import internship.framework.core.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static internship.framework.core.utility.ElementUtils.*;

public class RegisterCompletePage extends PageBase {

    @FindBy(xpath = "//div[@class='e-site-header-button e-site-header-button--menu']//a[@class='e-site-header-button__link']")
    private WebElement loginMenu;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameInputField;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameInputField;

    @FindBy(xpath = "//button[@class='button primary']")
    private WebElement buttonCompleteRegister;

    @FindBy(xpath = "//button[@class='button primary']")
    private WebElement buttonCompleteRegisterCheck;

    @FindBy(xpath = "//a[contains(text(),'My Account')]")
    private WebElement myAccountLabel;

    public RegisterCompletePage() {
        super();
    }

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
        clickOn(loginMenu);
        return doesAppear(myAccountLabel);
    }
}