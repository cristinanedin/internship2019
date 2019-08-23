package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.core.utility.DataProviders;
import internship.framework.pages.NavigationPage;
import internship.framework.pages.NavigationPage.Sections;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationPageTest extends TestBase {

    @Test(testName = "Open Navigation page",
            description = "Open Navigation page and verify sections",
            dataProvider = "sectionNavigation", dataProviderClass = DataProviders.class)
    public void checkNavigationPage(Sections sectionName) {
        NavigationPage navigationPage = new NavigationPage().openPage();
        navigationPage.goToPage(sectionName);
        Assert.assertEquals(navigationPage.getSectionUrl(),
                sectionName.getUrl(),
                "Does not match current url");
    }
}