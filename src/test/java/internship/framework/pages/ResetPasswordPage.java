package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.runner.GlobalProperties;
import internship.framework.core.utility.ElementUtils;
import internship.framework.core.utility.ProjectLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static internship.framework.core.utility.ElementUtils.doesAppear;

public class ResetPasswordPage extends PageBase {

    @FindBy(css = "div.reset-password-title")
    private WebElement resetPasswordText;

    @FindBy(css = "input#email")
    WebElement emailAddress;

    @FindBy(css = "button.button.primary")
    WebElement resetPasswordButton;

    @FindBy(css = "div.reset-password-title")
    WebElement resetConfirmationText;

    @FindBy(css = "p.control-error")
    WebElement incorrectEmailFormatText;

    public boolean isResetPasswordTextDisplayed() {
        ProjectLogger.info("Check if reset page is displayed.");
        return doesAppear(resetPasswordText);
    }

    public ResetPasswordPage enterValidPassword()
    {
        ElementUtils.fillInWithValue(emailAddress, GlobalProperties.USERNAME_VALUE);
        ProjectLogger.info("Enter valid email address.");
        return this;
    }

    public ResetPasswordPage enterInvalidPassword()
    {
        ElementUtils.fillInWithValue(emailAddress, GlobalProperties.INVALID_EMAIL_ADDRESS);
        ProjectLogger.info("Enter invalid email address.");
        return this;
    }

    public ResetPasswordPage clickResetPasswordButton()
    {
        ElementUtils.clickOn(resetPasswordButton);
        ProjectLogger.info("Click reset password button.");
        return this;
    }

    public boolean isResetConfirmationDisplayed()
    {
        ProjectLogger.info("Check reset confirmation page.");
        return ElementUtils.doesAppear(resetConfirmationText);
    }

    public boolean isIncorrectEmailFormatDisplayed()
    {
        ProjectLogger.info("Check if incorrect email format is displayed.");
        return ElementUtils.doesAppear(incorrectEmailFormatText);
    }

}
