package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.utility.ElementUtils;
import internship.framework.core.utility.PageUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageUrl("customer/subscribe/")
public class CustomerSubscribePage extends PageBase {
    @FindBy(xpath = "//p[.='Pay monthly']")
    private WebElement payMonthlyLocator;
    @FindBy(xpath = "//p[.='Free 30 day trial']")
    private WebElement dayTrialLocator;
    @FindBy(xpath = "//div[@class='card-heading']/span[text()='Standard Access']")
    private WebElement standardAccessLocator;
    @FindBy(xpath = "//article[1]//div[1]//span[4]")
    private WebElement perWeekLocator;
    @FindBy(xpath = "//div[@class='card-heading']/span[text()='All Digital Access']")
    private WebElement digitalAccessLocator;
    @FindBy(xpath = "//span[@class='card-heading-sub-heading'][contains(text(),'£3 per week')]")
    private WebElement perWeekLocator2;
    @FindBy(xpath = "//span[@class='card-heading-sub-heading'][text()='From £2 per week']")
    private WebElement perWeekLocator3;
    @FindBy(css = "div.tabs > button:nth-of-type(2)")
    private WebElement buttonAnually;
    @FindBy(xpath = "//span[@class='card-heading-sub-heading']['.=£100 per year']")
    private WebElement perYearLocator;
    @FindBy(xpath = "//span[@class='card-heading-sub-heading'][contains(text(),'£200 per year')]")
    private WebElement perYearLocator2;
    @FindBy(xpath = "//span[@class='card-heading-sub-heading'][text()='From £104 per year']")
    private WebElement perYearLocator3;

    public String getDisplayedPayMonthlyText() {
        return ElementUtils.getElementText(payMonthlyLocator);
    }

    public String getDisplayedTrial() {
        return ElementUtils.getElementText(dayTrialLocator);
    }

    public String getDisplayedStandardAccess() {
        return ElementUtils.getElementText(standardAccessLocator);
    }

    public String getDisplayedPerWeek() {

        return ElementUtils.getElementText(perWeekLocator);
    }

    public String getDisplayedDigitalAcces() {
        return ElementUtils.getElementText(digitalAccessLocator);
    }

    public String getDisplayedPerWeek2() {
        return ElementUtils.getElementText(perWeekLocator2);
    }

    public String getDisplayedPerWeek3() {
        return ElementUtils.getElementText(perWeekLocator3);
    }

    public boolean pushAnuallyButton() {
        ElementUtils.clickOn(buttonAnually);
        return true;
    }

    public String getDisplayedPerYear() {
        return ElementUtils.getElementText(perYearLocator);
    }

    public String getDisplayedPerYear2() {
        return ElementUtils.getElementText(perYearLocator2);
    }

    public String getDisplayedPerYear3() {
        return ElementUtils.getElementText(perYearLocator3);
    }
}
