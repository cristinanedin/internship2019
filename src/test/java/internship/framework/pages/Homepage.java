package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.utility.ElementUtils;
import internship.framework.core.utility.NavigationUtils;
import internship.framework.core.utility.ProjectLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static internship.framework.core.utility.ElementUtils.clickOn;
import static internship.framework.core.utility.ElementUtils.doesAppear;

public class Homepage extends PageBase {

    public Homepage() {
        super();
        super.open();
    }

    @FindBy(xpath = "//a[@class = 'header-logobar__link']")
    private WebElement telegraphLink;

    @FindBy(xpath = "//div[text()='Login']")
    private WebElement loginButton;

    @FindBy(css = "a[title=Register]")
    private WebElement registerButton;



    @Override
    public void open() {
        super.open();
        NavigationUtils.deleteCookiesAndRefresh();
    }

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


}