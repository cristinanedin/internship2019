package internship.framework.pages;

import internship.framework.core.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static internship.framework.core.utility.ElementUtils.clickOn;
import static internship.framework.core.utility.ElementUtils.waitFor;

public class MoreMenu extends PageBase {

    public MoreMenu() {
        super();
    }

    @FindBy (xpath = "(//li[@role='menuitem'])[1]")
    private WebElement username;

    @FindBy (xpath = "(//li[@role='menuitem'])[2]")
    private WebElement logoutButton;

    public void clickLogoutButton() {
        clickOn(logoutButton);
    }

    public String getUserName() {
        waitFor(username);
        return username.getText();
    }
}