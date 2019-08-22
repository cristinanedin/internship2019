package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.pages.Homepage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    @Test(testName = "Open telegraph page",
            description = "Open page and verify logo",
            priority = 1)
    public void checkHomePageLogo() {

        Homepage homepage = new Homepage().openPage();
        Assert.assertTrue(homepage.isTelegraphLogoDisplayed(), "Page is not opened correctly");
    }

}
