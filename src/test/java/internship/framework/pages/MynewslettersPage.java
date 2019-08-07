package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.utility.ElementUtils;
import internship.framework.core.utility.ProjectLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MynewslettersPage extends PageBase {

    @FindBy(xpath = "//div[@class='account-newsletters-list']//div[1]//div[1]//button[1]")
    private WebElement firstSubscribeButton;

    @FindBy(xpath = "//section[@class='centered-content account-newsletters recommended']//div[2]//div[1]//button[1]")
    private WebElement secondSubscribeButton;

    @FindBy(xpath = "//section[@class='centered-content account-newsletters recommended']//div[3]//div[1]//button[1]")
    private WebElement thirdSubscribeButton;

    @FindBy(xpath = "//h2[@class='my-newsletters toggled']")
    private WebElement myNewslettersElement;

    @FindBy(xpath = "//section[@class='centered-content account-newsletters']//div[@class='account-newsletters-list']//div[2]//div[1]//button[1]")
    private WebElement unsubscribeSecondNewsletterButton;

    @FindBy(xpath = "//section[@class='centered-content account-newsletters']//div[@class='account-newsletters-list']//div[3]//div[1]//button[1]")
    private WebElement unsubscribeThirdNewsletterButton;

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
        ElementUtils.clickOn(unsubscribeThirdNewsletterButton);
        ElementUtils.clickOn(unsubscribeSecondNewsletterButton);
        return this;
    }

    public MynewslettersPage clickRightTopArrow() {
        ProjectLogger.info("Click top right arrow.");
        ElementUtils.clickOn(topRightArrow);
        return this;
    }
}
