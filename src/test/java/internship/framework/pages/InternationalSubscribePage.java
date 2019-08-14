package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.utility.Driver;
import internship.framework.core.utility.ProjectLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static internship.framework.core.runner.GlobalProperties.INTERNATIONAL_SUBSCRIPTION_URL;
import static internship.framework.core.utility.ElementUtils.clickOn;
import static internship.framework.core.utility.ElementUtils.getElementText;

public class InternationalSubscribePage extends PageBase {

    @FindBy(xpath = "//body/div[@id='___gatsby']/div/div/div/div/div[@class='sc-cvbbAY abKmD']/div[@class='sc-bdVaJa jPQSoW']/div[@class='sc-eHgmQL hxYKLw']/div[@class='sc-jWBwVP dLxNyV']/div[@class='sc-brqgnP bQuYpU']/div[@class='sc-iwsKbI fRSnXO']/div[@class='sc-kGXeez gsQlBk']/div[2]")
    private WebElement payMonthlyStandardAccessPrice;

    @FindBy(xpath = "//body/div[@id='___gatsby']/div/div/div/div/div[@class='sc-cvbbAY abKmD']/div[@class='sc-bdVaJa jPQSoW']/div[@class='sc-eHgmQL hxYKLw']/div[@class='sc-jWBwVP dLxNyV']/div[@class='sc-brqgnP bQuYpU']/div[@class='sc-iwsKbI jLcisc']/div[@class='sc-kGXeez gsQlBk']/div[2]")
    private WebElement payMonthlyAllDigitalAccessPrice;

    @FindBy(xpath = "//div[@class='sc-kkGfuU HOhSJ']")
    private WebElement payAnnuallyElement;

    @FindBy(xpath = "//body/div[@id='___gatsby']/div/div/div/div/div[@class='sc-cvbbAY abKmD']/div[@class='sc-bdVaJa jPQSoW']/div[@class='sc-eHgmQL hxYKLw']/div[@class='sc-jWBwVP dLxNyV']/div[@class='sc-brqgnP bQuYpU']/div[@class='sc-iwsKbI fRSnXO']/div[@class='sc-kGXeez gsQlBk']/div[2]")
    private WebElement payAnnuallyStandardAccessPrice;

    @FindBy(xpath = "//body/div[@id='___gatsby']/div/div/div/div/div[@class='sc-cvbbAY abKmD']/div[@class='sc-bdVaJa jPQSoW']/div[@class='sc-eHgmQL hxYKLw']/div[@class='sc-jWBwVP dLxNyV']/div[@class='sc-brqgnP bQuYpU']/div[@class='sc-iwsKbI jLcisc']/div[@class='sc-kGXeez gsQlBk']/div[2]")
    private WebElement payAnnuallyAllDigitalAccessPrice;

    @FindBy(xpath = "//div[@class='sc-Rmtcm EeDiq']")
    private WebElement unlimitedAccess24HoursPrice;

    public InternationalSubscribePage open() {
        Driver.get().get(INTERNATIONAL_SUBSCRIPTION_URL);
        WebDriverWait wait = new WebDriverWait(Driver.get(), 30);
        wait.until(ExpectedConditions.urlContains(INTERNATIONAL_SUBSCRIPTION_URL));
        Driver.get().switchTo().defaultContent();
        return this;
    }

    public String payMonthlyStandardAccessPriceText() {
        ProjectLogger.info("Check if Pay Monthly Standard Access price is displayed in dollars.");
        return getElementText(payMonthlyStandardAccessPrice);
    }

    public String payMonthlyAllDigitalAccessPriceText() {
        ProjectLogger.info("Check if Pay Monthly All Digital Access price is displayed in dollars.");
        return getElementText(payMonthlyAllDigitalAccessPrice);
    }

    public void clickPayAnnuallyElement() {
        ProjectLogger.info("Navigate to Pay annually tab.");
        clickOn(payAnnuallyElement);
    }

    public String payAnnuallyStandardAccessPriceText() {
        ProjectLogger.info("Check if Pay Annually Standard Access price is displayed in dollars.");
        return getElementText(payAnnuallyStandardAccessPrice);
    }

    public String payAnnuallyAllDigitalAccessPriceText() {
        ProjectLogger.info("Check if Pay Annually All Digital Access price is displayed in dollars.");
        return getElementText(payAnnuallyAllDigitalAccessPrice);
    }

    public String unlimitedAccess24HoursPriceText() {
        ProjectLogger.info("Check if Unlimited Access 24 hours price is displayed in dollars.");
        return getElementText(unlimitedAccess24HoursPrice);
    }
}
