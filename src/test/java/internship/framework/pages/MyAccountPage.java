package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.utility.ElementUtils;
import internship.framework.core.utility.ProjectLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

    @FindBy(css = "a[title='My newsletters']")
    private WebElement myNewslettersButton;

    public MynewslettersPage clickMyNewslettersButton() {
        ProjectLogger.info("Navigate to My newsletters Page");
        ElementUtils.clickOn(myNewslettersButton);
        return new MynewslettersPage();
    }
}
