package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.utility.NavigationUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static internship.framework.core.utility.ElementUtils.doesAppear;

public class Homepage extends PageBase {

    public Homepage() {
        super();
    }

    @FindBy (xpath = "//a[@class = 'header-logobar__link']")
    private WebElement telegraphLink;

    @Override
    public void open() {
        super.open();
        NavigationUtils.deleteCookiesAndRefresh();
    }

    public boolean isTelegraphLogoDisplayed() {
        return doesAppear(telegraphLink);
    }
}