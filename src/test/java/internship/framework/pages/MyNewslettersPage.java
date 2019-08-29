package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.utility.ProjectLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static internship.framework.core.utility.ElementUtils.*;

public class MyNewslettersPage extends PageBase {

    @FindBy(xpath = "//div[@class='account-newsletters-list']//div[1]//div[2]//button[1]")
    private WebElement firstSubscribeButton;

    @FindBy(xpath = "//section[@class='centered-content account-newsletters recommended']//div[2]//div[2]//button[1]")
    private WebElement secondSubscribeButton;

    @FindBy(xpath = "//section[@class='centered-content account-newsletters recommended']//div[3]//div[2]//button[1]")
    private WebElement thirdSubscribeButton;

    @FindBy(xpath = "//h2[@class='my-newsletters toggled']")
    private WebElement myNewslettersElement;

    @FindBy(xpath = "//section[@class='centered-content account-newsletters recommended']//div[@class='account-newsletters-list']//div[1]//div[1]//button[1]")
    private WebElement unsubscribeFirstNewsletterButton;

    @FindBy(xpath = "//section[@class='centered-content account-newsletters recommended']//div[2]//div[1]//button[1]")
    private WebElement unsubscribeSecondNewsletterButton;

    @FindBy(xpath = "//section[@class='centered-content account-newsletters recommended']//div[3]//div[1]//button[1]")
    private WebElement unsubscribeThirdNewsletterButton;

    @FindBy(xpath = "//h2[@class='my-newsletters']")
    private WebElement topRightArrow;

    @FindBy(xpath = "//h2[@class='my-newsletters toggled']")
    private WebElement topRightArrowToggled;

    @FindBy(xpath = "//div[@class='account-newsletters-list']//button[@class='button default']")
    private WebElement unCheckSubscribeNewsletterButton;

    public MyNewslettersPage addNewsletters() {
        ProjectLogger.info("Add Newsletters.");
        clickOn(thirdSubscribeButton);
        clickOn(secondSubscribeButton);
        clickOn(firstSubscribeButton);
        return this;
    }

    public boolean checkSubscribeNewsletters() {
        ProjectLogger.info("Check is My newsletters element is displayed.");
        return doesAppear(myNewslettersElement);
    }

    public MyNewslettersPage unsubscribeNewsletters() {
        ProjectLogger.info("Unsubscribe newsletters.");
        clickOnWithJs(unsubscribeThirdNewsletterButton);
        clickOnWithJs(unsubscribeSecondNewsletterButton);
        clickOnWithJs(unsubscribeFirstNewsletterButton);
        return this;
    }

    public MyNewslettersPage clickRightTopArrow() {
        ProjectLogger.info("Click top right arrow.");
        clickOnWithJs(topRightArrowToggled);
        return this;
    }

    public MyNewslettersPage unClickRightTopArrow() {
        ProjectLogger.info("UnClick top right arrow.");
        clickOnWithJs(topRightArrow);
        return this;
    }

    public MyNewslettersPage uncheckNewsletter() {
        ProjectLogger.info("UnCheck newsletter.");
        clickOnWithJs(unCheckSubscribeNewsletterButton);
        return this;
    }
}
