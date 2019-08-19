package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.utility.ProjectLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static internship.framework.core.utility.ElementUtils.getElementText;

public class TermsAndConditionsPage extends PageBase {

    @FindBy(xpath = "//h1[@class='headline__heading']")
    private WebElement termsAndConditionsTitleText;

    @FindBy(xpath = "//b[contains(text(),'Policies and Processes')]")
    private WebElement policiesAndProcessesChapterTitleText;

    public String getTermsAndConditionsTitleText()
    {
        ProjectLogger.info("Check if Terms and Conditions element is displayed.");
        return  getElementText(termsAndConditionsTitleText);
    }

    public String getPoliciesAndProcessesChapterText()
    {
        ProjectLogger.info("Check if Policies and Processes element is displayed.");
        return  getElementText(policiesAndProcessesChapterTitleText);
    }
}
