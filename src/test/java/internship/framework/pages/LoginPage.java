package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.utility.ElementUtils;
import internship.framework.core.utility.ProjectLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static internship.framework.core.utility.ElementUtils.doesAppear;


public class LoginPage extends PageBase {

    public LoginPage() {
        super();
    }

    @FindBy(id = "email")
    private WebElement emailInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/form/div[4]/button")
    private WebElement loginButton;

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
}