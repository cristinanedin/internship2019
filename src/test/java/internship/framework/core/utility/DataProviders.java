package internship.framework.core.utility;

import org.testng.annotations.DataProvider;

import static internship.framework.pages.NavigationPage.Sections.*;

public class DataProviders {

    private DataProviders() {
    }

    @DataProvider(name = "sectionNavigation")
    private static Object[][] getSectionNames() {
        return new Object[][]{
                {NEWS},
                {POLITICS},
                {SPORT},
                {TECHNOLOGY},
                {BUSINESS},
                {MONEY},
                {OPINION},
                {LIFESTYLE},
                {CULTURE},
                {TRAVEL}
        };
    }
}