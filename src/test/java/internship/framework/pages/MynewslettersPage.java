package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.utility.ElementUtils;
import internship.framework.core.utility.ProjectLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MynewslettersPage extends PageBase {

    @FindBy(xpath = "(//button[@class='button primary'])[1]")
    private WebElement firstSubscribeButton;

    @FindBy(xpath = "(//button[@class='button primary'])[2]")
    private WebElement secondSubscribeButton;

    @FindBy(xpath = "(//button[@class='button primary'])[3]")
    private WebElement thirdSubscribeButton;

    @FindBy(xpath = "//h2[@class='my-newsletters toggled']")
    private WebElement myNewslettersElement;

    @FindBy(xpath = "(//button[@class='button default'])[1]")
    private WebElement unsubscribeNewsletterButton;

    @FindBy(xpath = "//h2[@class='my-newsletters toggled']")
    private WebElement topRightArrow;

    public MynewslettersPage addNewsletters() {
        ProjectLogger.info("Add Newsletters.");
        ElementUtils.clickOn(thirdSubscribeButton);
        ElementUtils.clickOn(secondSubscribeButton);
        ElementUtils.clickOn(firstSubscribeButton);
        return this;
    }

    public boolean checkSubscribeNewsletters() {
        ProjectLogger.info("Check is My newsletters element is displayed.");
        return ElementUtils.doesAppear(myNewslettersElement);
    }

    public MynewslettersPage unsubscribeNewsletters() {
        ProjectLogger.info("Unsubscribe two newsletters.");
        ElementUtils.clickOn(unsubscribeNewsletterButton);
        ElementUtils.clickOn(unsubscribeNewsletterButton);
        return this;
    }

    public MynewslettersPage clickRightTopArrow() {
        ProjectLogger.info("Click top right arrow.");
        ElementUtils.clickOn(topRightArrow);
        return this;
    }
}
