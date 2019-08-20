package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.utility.Driver;
import internship.framework.core.utility.ElementUtils;
import internship.framework.core.utility.ProjectLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrivacyAndCookiePolicyPage extends PageBase {

    @FindBy(xpath = "//h1[contains(@class,'headline__heading')]")
    private WebElement privacyAndCookiePolicyTitleText;

    public String getPrivacyAndCookiePolicyTitleText()
    {
        ProjectLogger.info("Get Privacy and Cookie Policy element's text.");
        return ElementUtils.getElementText(privacyAndCookiePolicyTitleText);
    }

    public String getPrivacyAndCookiePolicyUrl()
    {
        ProjectLogger.info("Get Privacy and Cookie Policy Url.");
        return Driver.get().getCurrentUrl();
    }
}
