package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.core.utility.Driver;
import internship.framework.core.utility.TestUtils;
import internship.framework.pages.PersonalDetailsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class PersonalDetailsTest extends TestBase {
    public static ThreadLocal<SoftAssert> softAssert = new ThreadLocal<>();

    @Test(testName = "Personal details test",
            description = "Testing personal details.")
    public void checkPersonalDetailsFunctionality() {
        TestUtils.login("stroeradu03@gmail.com", "qwer1234");
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage().navigatePersonalDetails();
        editPersonalDetails();
        softAssert.get().assertTrue(personalDetailsPage.isValidateChangesDisplayed(),
                "Valid changes element is not displayed.");
        personalDetailsPage.selectAllContactPreferences()
                .navigateSubscriptionDetailsTab()
                .navigatePersonalDetailsTab();
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssert.get().assertTrue(personalDetailsPage.areALLCheckboxesSelected(), "Not every checkbox is selected.");
        softAssert.get().assertAll();
    }

    @Override
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        softAssert.remove();
        super.tearDown();
    }

    private void editPersonalDetails() {
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        personalDetailsPage.clickEditDetailsElement()
                .selectTitle()
                .fillWithValueFirstName()
                .fillWithValueLastName()
                .fillWithValueAddress()
                .fillWithValueCityTown()
                .selectCountry()
                .fillWithValueTelephone()
                .clickSaveChangesButton();
    }
}
