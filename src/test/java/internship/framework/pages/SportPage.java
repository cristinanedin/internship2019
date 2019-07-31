package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.utility.ElementUtils;
import internship.framework.core.utility.PageUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@PageUrl("customer/subscribe/sport/")
public class SportPage extends PageBase {

    @FindBy(xpath = "//div[@class='card-heading']/span[text()='Sport Subscription - Half-price sale']")
    private WebElement sportSubscription;


    @FindBy (xpath = "//div[@class='card-multi-button-list-element-text-container']/p[text()='£1 per week']")
    private WebElement onePoundWeekly;


    @FindBy (xpath = "//div[@class='card-multi-button-list-element-text-container-body']/p[text()='Free for 30 days then billed as £4.33 per month']")
    private WebElement fourPoundsMonthly;


    @FindBy (xpath = "//div[@class='card-multi-button-list-element-text-container']/p[text()='£20 per year']")
    private WebElement twentyYearly;

    @FindBy (xpath = "//div[@class='card-multi-button-list-element-text-container-body']/p[text()='Half-price sale']")
    private WebElement halfPriceYearly;


    public String getSportSubscription(){

        return ElementUtils.getElementText(sportSubscription);
    }

    public String getWeeklyPayment(){

        return ElementUtils.getElementText(onePoundWeekly);
    }

    public String getMonthlyPayment(){
        return ElementUtils.getElementText(fourPoundsMonthly);
    }

    public String getYearlyPayment(){
        return ElementUtils.getElementText(twentyYearly);
    }

    public String getYearlyHalfPayment(){
        return ElementUtils.getElementText(halfPriceYearly);
    }



}