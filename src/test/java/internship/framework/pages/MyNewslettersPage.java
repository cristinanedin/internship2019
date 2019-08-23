package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.utility.ProjectLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static internship.framework.core.utility.ElementUtils.*;

public class MyNewslettersPage extends PageBase {

    @FindBy(xpath = "//div[@class='account-newsletters-list']//div[1]//div[1]//button[1]")
    private WebElement firstSubscribeButton;

    @FindBy(xpath = "//section[@class='centered-content account-newsletters recommended']//div[2]//div[1]//button[1]")
    private WebElement secondSubscribeButton;

    @FindBy(xpath = "//section[@class='centered-content account-newsletters recommended']//div[3]//div[1]//button[1]")
    private WebElement thirdSubscribeButton;

    @FindBy(xpath = "//h2[@class='my-newsletters toggled']")
    private WebElement myNewslettersElement;

    @FindBy(xpath = "//section[@class='centered-content account-newsletters']//div[@class='account-newsletters-list']//button[@class='button default']")
    private WebElement unsubscribeFirstNewsletterButton;

    @FindBy(xpath = "//section[@class='centered-content account-newsletters']//div[@class='account-newsletters-list']//div[2]//div[1]//button[1]")
    private WebElement unsubscribeSecondNewsletterButton;

    @FindBy(xpath = "//section[@class='centered-content account-newsletters']//div[@class='account-newsletters-list']//div[3]//div[1]//button[1]")
    private WebElement unsubscribeThirdNewsletterButton;

    @FindBy(xpath = "//div[@class='account-newsletters-list']//div[4]//div[1]//button[1]")
    private WebElement unsubscribeFourthNewsletterButton;

    @FindBy(xpath = "//h2[@class='my-newsletters toggled']")
    private WebElement topRightArrow;

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
        ProjectLogger.info("Unsubscribe two newsletters.");
        clickOnWithJs(unsubscribeThirdNewsletterButton);
        clickOnWithJs(unsubscribeSecondNewsletterButton);
        return this;
    }

    public MyNewslettersPage clickRightTopArrow() {
        ProjectLogger.info("Click top right arrow.");
        clickOn(topRightArrow);
        return this;
    }

    public MyNewslettersPage uncheckNewsletters() {
        ProjectLogger.info("Uncheck Newsletters.");
        clickOnWithJs(unsubscribeFourthNewsletterButton);
        clickOnWithJs(unsubscribeThirdNewsletterButton);
        clickOnWithJs(unsubscribeSecondNewsletterButton);
        clickOnWithJs(unsubscribeFirstNewsletterButton);
        return this;
    }
}
