package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.utility.ElementUtils;
import internship.framework.core.utility.ProjectLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

    @FindBy(css = "a[title='My newsletters']")
    private WebElement myNewslettersButton;

    @FindBy(xpath = "//div[@class='newsletters-home-cards-content']//div[1]//div[1]//button[1]")
    private WebElement firstNewsletterButton;

    @FindBy(xpath = "//div[@class='toast-content']")
    private WebElement validateNewsletter;

    @FindBy(xpath = "//a[contains(text(),'My Account')]")
    private WebElement MyAccountElement;

    public MyAccountPage clickMyNewslettersButton() {
        ProjectLogger.info("Navigate to My newsletters page.");
        ElementUtils.clickOn(myNewslettersButton);
        return this;
    }

    public MyAccountPage addNewsletter()
    {
        ProjectLogger.info("Add newsletter.");
        ElementUtils.clickOn(firstNewsletterButton);
        return this;
    }

    public boolean isValidateNewsletterDisplayed()
    {
        ProjectLogger.info("Check if validate newsletter element is displayed.");
        return ElementUtils.doesAppear(validateNewsletter);

    }

    public String getValidateNewsletterText()
    {
        ProjectLogger.info("Check if validate newsletter text matches.");
        return ElementUtils.getElementText(validateNewsletter);
    }

    public MyAccountPage navigateMyAccount()
    {
        ProjectLogger.info("Navigate to My Account tab.");
        ElementUtils.clickOn(MyAccountElement);
        return this;
    }
}
